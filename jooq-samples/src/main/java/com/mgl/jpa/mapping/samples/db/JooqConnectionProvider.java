package com.mgl.jpa.mapping.samples.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.jooq.ConnectionProvider;
import org.jooq.impl.DataSourceConnectionProvider;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.mgl.jpa.mapping.samples.db.DbConfiguration.DbConfigurationBuilder;

@Slf4j
public class JooqConnectionProvider {

    @NonNull private final DbConfigurationBuilder dbConfigurationBuilder;

    @NonNull private /* final */ HikariDataSource ds;

    @Inject
    public JooqConnectionProvider(DbConfigurationBuilder dbConfigurationBuilder) {
        this.dbConfigurationBuilder = dbConfigurationBuilder;
    }

    @PostConstruct
    public void init() {
        log.info("Creating data source");
        DbConfiguration dbConfiguration = dbConfigurationBuilder.build();
        HikariConfig config = dbConfiguration.toHikariConfig();
        ds = new HikariDataSource(config);
    }

    @PreDestroy
    public void destroy() {
        log.info("Destroying data source");
        ds.close();
    }

    @Produces
    @ApplicationScoped
    public ConnectionProvider produceConnectionProvider() {
        log.info("Producing a connection provider");
        return new DataSourceConnectionProvider(ds);
    }

}
