package com.mgl.jpa.mapping.samples.jooq;

import com.mgl.jpa.mapping.samples.db.support.BaseTest;
import com.mgl.jpa.mapping.samples.jooq.tables.daos.CompanyDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class SampleTest extends BaseTest {

    @Test
    public void testSample() {
        CompanyDao companyDao = new CompanyDao(configuration());
        companyDao.findAll().stream().map(String::valueOf).forEach(log::info);
    }

}
