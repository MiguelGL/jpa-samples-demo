package com.mgl.jpa.mapping.samples;

import java.util.Date;
import java.util.List;

import com.mgl.jpa.mapping.samples.support.BaseJpaTestSupport;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.junit.Test;

public class RegularUserTest extends BaseJpaTestSupport {

    @Test
    public void testCreateNew() {
        Company company = new Company();
        company.setOrganisationName("JUnit tests company");
        company.setEmail("test@company.com");

        em().persist(company);

        RegularUser userProfile = new RegularUser();
        userProfile.setCompany(company);
        userProfile.setEmail("test@email.com");
        userProfile.setSignUpTs(new Date());
        userProfile.setRegistrationSource(RegistrationSource.MANUAL);

        em().persist(userProfile);

        commitAndBeginTransactionAgain();

        em().remove(em().find(RegularUser.class, userProfile.getId()));
    }

    @Test
    public void testQueryDsl() {
        QRegularUser qru = QRegularUser.regularUser;

        JPAQuery<RegularUser> query = new JPAQuery<>(em());

        BooleanExpression searchPredicate = qru
                .contactInformation.email.eq("anemailaddress@gmail.com")
                .and(qru.company.organisationName.startsWithIgnoreCase("aqua"));

        List<RegularUser> res = query
                .select(qru)
                .from(qru)
                .where(searchPredicate)
                .fetch();

        // Loop and process results - res
    }

}
