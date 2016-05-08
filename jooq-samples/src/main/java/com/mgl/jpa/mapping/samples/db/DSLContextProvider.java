package com.mgl.jpa.mapping.samples.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.ConnectionProvider;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DataSourceConnectionProvider;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.mgl.jpa.mapping.samples.db.DbConfiguration.DbConfigurationBuilder;

@Slf4j
@RequiredArgsConstructor(onConstructor=@__({@Inject}))
public class DSLContextProvider {

    @NonNull private final ConnectionProvider connectionProvider;

    @Produces @ApplicationScoped
    public DSLContext produceDSLContext() {
        log.info("Producing a DSL context");
        // PG: return DSL.using(connectionProvider, SQLDialect.POSTGRES_9_4);
        return DSL.using(connectionProvider, SQLDialect.MYSQL);
    }

    @ApplicationScoped
    public void destroyDSLContext(@Disposes DSLContext dslContext) {
        log.info("Disposing a DSL context");
        dslContext.close();
    }

    @Slf4j
    public static class JooqConnectionProvider {

        @NonNull private final DbConfigurationBuilder dbConfigurationBuilder;

        @NonNull private /* final */ HikariDataSource ds;

        @Inject
        public JooqConnectionProvider(DbConfigurationBuilder dbConfigurationBuilder) {
            this.dbConfigurationBuilder = dbConfigurationBuilder;
        }

        @PostConstruct
        public void init() {
            JooqConnectionProvider.log.info("Creating data source");
            DbConfiguration dbConfiguration = dbConfigurationBuilder.build();
            HikariConfig config = dbConfiguration.toHikariConfig();
            ds = new HikariDataSource(config);
        }

        @PreDestroy
        public void destroy() {
            JooqConnectionProvider.log.info("Destroying data source");
            ds.close();
        }

        @Produces
        @ApplicationScoped
        public ConnectionProvider produceConnectionProvider() {
            JooqConnectionProvider.log.info("Producing a connection provider");
            return new DataSourceConnectionProvider(ds);
        }

    }
}
