package com.mgl.jpa.mapping.samples;

import com.mgl.jpa.mapping.samples.support.BaseJpaTestSupport;
import org.junit.Test;

public class CompanyTest extends BaseJpaTestSupport {

    @Test
    public void testCreateNew() throws InterruptedException {
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
    }

}
