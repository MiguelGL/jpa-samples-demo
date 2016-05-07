package com.mgl.jpa.mapping.samples;

import java.util.List;
import java.util.stream.Stream;

import com.mgl.jpa.mapping.samples.support.BaseJpaTestSupport;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.junit.Assert;
import org.junit.Test;

public class CompanyTest extends BaseJpaTestSupport {

    @Test
    public void testMisc() throws InterruptedException {
        final Company company = new Company("JUnit single organisation", "email@organisation.com");
        em().persist(company);

        commitAndBeginTransactionAgain();
        Thread.sleep(1_000); // For lastUpdateTs to change

        final Company sameCompany = em().find(Company.class, company.getId());
        sameCompany.setFirstName("Junit");
        sameCompany.setLastName("Tests");
        em().merge(sameCompany);

        commitAndBeginTransactionAgain();
        Thread.sleep(1_000); // For lastUpdateTs to change

        final Company sameCompanyAgain = em().find(Company.class, company.getId());
        sameCompanyAgain.setFirstName("JunitAgain");
        sameCompanyAgain.setLastName("TestsAgain");
        sameCompanyAgain.setEmail("emailaddress@organisation.com");
        em().merge(sameCompanyAgain);

        commitAndBeginTransactionAgain();

        AuditReader auditReader = AuditReaderFactory.get(em());
        List<Object[]> auditions = auditReader.createQuery()
                .forRevisionsOfEntity(Company.class, false, true)
                .add(AuditEntity.id().eq(company.getId()))
                .getResultList();
        auditions.forEach(audition -> {
            System.out.println("---");
            Stream.of(audition)
                    .map(String::valueOf)
                    .map("-> "::concat)
                    .forEach(System.out::println);
        });
        Assert.assertTrue(auditions.size() == 3);

        commitAndBeginTransactionAgain();

        em().remove(em().find(Company.class, sameCompanyAgain.getId()));
    }

}
