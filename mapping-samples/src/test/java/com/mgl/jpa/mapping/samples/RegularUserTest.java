package com.mgl.jpa.mapping.samples;

import java.util.Date;

import com.mgl.jpa.mapping.samples.support.BaseJpaTestSupport;
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
    }

}
