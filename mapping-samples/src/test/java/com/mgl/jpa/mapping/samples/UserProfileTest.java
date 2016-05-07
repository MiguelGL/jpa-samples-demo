package com.mgl.jpa.mapping.samples;

import java.util.Date;

import com.mgl.jpa.mapping.samples.support.BaseJpaTestSupport;
import org.junit.Test;

public class UserProfileTest extends BaseJpaTestSupport {

    @Test
    public void testCreateNew() {
        Company company = new Company();
        company.setOrganisationName("JUnit tests company");
        company.setEmail("test@company.com");

        em().persist(company);

        UserProfile userProfile = new UserProfile();
        userProfile.setCompany(company);
        userProfile.setEmail("test@email.com");
        userProfile.setSignUpTs(new Date());
        userProfile.setRegistrationSource(RegistrationSource.MANUAL);

        em().persist(userProfile);
    }

}
