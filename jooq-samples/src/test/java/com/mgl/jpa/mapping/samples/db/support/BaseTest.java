package com.mgl.jpa.mapping.samples.db.support;

import com.mgl.jpa.mapping.samples.db.DSLContextProvider;
import com.mgl.jpa.mapping.samples.db.DSLContextProvider.JooqConnectionProvider;
import com.mgl.jpa.mapping.samples.db.DbConfiguration;
import com.mgl.jpa.mapping.samples.db.DbConfiguration.DbConfigurationBuilder;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;

@Slf4j
@Accessors(fluent = true)
public abstract class BaseTest {

    private static JooqConnectionProvider connProvider;
    @Getter private static DSLContext dslContext;

    protected Configuration configuration() {
        return dslContext().configuration();
    }

    @BeforeClass
    public static void setUpClass() {
        log.info("Preparing DB stuff ...");
        DbConfigurationBuilder dbConfigurationBuilder = DbConfiguration.builderWithDefaults();
        connProvider = new DSLContextProvider.JooqConnectionProvider(dbConfigurationBuilder);
        connProvider.init();

        DSLContextProvider dslContextProvider =
                new DSLContextProvider(connProvider.produceConnectionProvider());
        dslContext = dslContextProvider.produceDSLContext();
    }

    @AfterClass
    public static void tearDownClass() {
        if (dslContext != null) {
            dslContext.close();
            dslContext = null;
        }

        if (connProvider != null) {
            connProvider.destroy();
            connProvider = null;
        }
    }

}
