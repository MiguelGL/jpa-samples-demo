package com.mgl.jpa.mapping.samples.jooq;

import static com.mgl.jpa.mapping.samples.jooq.Tables.*;

import com.mgl.jpa.mapping.samples.db.support.BaseTest;
import com.mgl.jpa.mapping.samples.jooq.tables.daos.CompanyDao;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Record2;
import org.jooq.Result;
import org.junit.Test;

@Slf4j
public class SampleTest extends BaseTest {

    @Test
    public void testBasicJooqSample() {
        CompanyDao companyDao = new CompanyDao(configuration());
        companyDao.findAll().stream().map(String::valueOf).forEach(log::info);

        Result<Record2<String, String>> results = dslContext()
                .select(COMPANY.ORGANISATIONNAME, USERPROFILE.EMAIL)
                .from(COMPANY)
                .join(USERPROFILE)
                .on(COMPANY.ID.eq(USERPROFILE.COMPANY_ID))
                .join(REGULARUSER)
                .on(REGULARUSER.ID.eq(USERPROFILE.ID))
                .fetch();

        // Loop and process results
    }

}
