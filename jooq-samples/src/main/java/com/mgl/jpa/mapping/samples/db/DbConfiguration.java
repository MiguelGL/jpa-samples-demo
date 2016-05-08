package com.mgl.jpa.mapping.samples.db;

import com.google.common.collect.ImmutableMap;
import com.zaxxer.hikari.HikariConfig;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;
// PG: import org.postgresql.PGProperty;

import java.util.Map;
import java.util.Optional;

@Builder(builderClassName = "DbConfigurationBuilder", toBuilder = true)
@Data @Setter(AccessLevel.PACKAGE)
@ToString
public class DbConfiguration {

    // https://github.com/brettwooldridge/HikariCP#popular-datasource-class-names

    // https://github.com/brettwooldridge/HikariCP/wiki/MySQL-Configuration
    private static final String MYSQL_PLAIN_DS_CLASS_NAME = "com.mysql.cj.jdbc.MysqlDataSource";
    private static final String MYSQL_POOL_DS_CLASS_NAME = "com.mysql.cj.jdbc.MysqlConnectionPoolDataSource";
    private static final String MYSQL_XA_DS_CLASS_NAME = "com.mysql.cj.jdbc.MysqlXADataSource";

    // PG: private static final String PG_PLAIN_DS_CLASS_NAME = "org.postgresql.ds.PGSimpleDataSource";
    // PG: private static final String PG_POOL_DS_CLASS_NAME = "org.postgresql.ds.PGConnectionPoolDataSource";
    // PG: private static final String PG_XA_DS_CLASS_NAME = "org.postgresql.xa.PGXADataSource";

    // PG: private static final String PG_PLAIN_DS_CLASS_NAME = "com.impossibl.postgres.jdbc.PGDataSource";
    // PG: private static final String PG_POOL_DS_CLASS_NAME = "com.impossibl.postgres.jdbc.PGConnectionPoolDataSource";
    // PG: private static final String PG_XA_DS_CLASS_NAME = "com.impossibl.postgres.jdbc.xa.PGXADataSource";

    public static final String DEF_DB_HOST = "localhost";
    // PG: public static final int DEF_DB_PORT = 5432;
    public static final int DEF_DB_PORT = 3306;

    public static final String DEF_DB_NAME = "jpa";

    public static final String DEF_DB_USER = DEF_DB_NAME;
    public static final String DEF_DB_PASSWORD = DEF_DB_NAME;

    public static final String DEF_CONN_POOL_NAME = "jpa-samples-pool";

    public static final int DEF_MAX_POOL_SIZE = 10;

    @NonNull private final String dbHost;
    private final int dbPort;

    @NonNull private final String dbName;

    @NonNull private final String dbUser;
    @NonNull private final String dbPassword;

    @Getter(AccessLevel.PRIVATE) private final String poolName;

    private final int maxPoolSize;

    @NonNull @Singular private final Map<String, ? extends Object> dsProperties;

    public static DbConfigurationBuilder builderWithDefaults() {
        return builder()
                .dbHost(DEF_DB_HOST)
                .dbPort(DEF_DB_PORT)
                .dbName(DEF_DB_NAME)
                .dbUser(DEF_DB_USER)
                .dbPassword(DEF_DB_PASSWORD)
                .poolName(DEF_CONN_POOL_NAME)
                .maxPoolSize(DEF_MAX_POOL_SIZE)
                .dsProperties(ImmutableMap.of());
    }

    private String buildMySqlDbUrl() {
        return String.format(
                "jdbc:mysql://%s:%d/%s?zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=UTC",
                getDbHost(), getDbPort(), getDbName());
    }

    public HikariConfig toHikariConfig() {
        HikariConfig config = new HikariConfig();
        // PG: config.setDataSourceClassName(PG_PLAIN_DS_CLASS_NAME);
        config.setDataSourceClassName(MYSQL_PLAIN_DS_CLASS_NAME);
        // DataSource config. recommended over jdbcUrl
        // https://github.com/brettwooldridge/HikariCP#popular-datasource-class-names
        // config.setJdbcUrl(String.format("jdbc:pgsql://%s:%d/%s",
        //         getDbHost(), getDbPort(), getDbName()));
        config.setPoolName(getPoolName());
        config.setUsername(getDbUser());
        config.setPassword(getDbPassword());
        config.setMaximumPoolSize(getMaxPoolSize());
        // These below are specific to our PostgreSQL DB driver:
        // https://github.com/impossibl/pgjdbc-ng#configuration
        // config.addDataSourceProperty("user", getDbUser());
        // config.addDataSourceProperty("password", getDbPassword());
        // config.addDataSourceProperty("database", getDbName());
        // config.addDataSourceProperty("port", getDbPort());
        // config.addDataSourceProperty("host", getDbHost());

        // PG: And these for the org.postgresql.ds.PGSimpleDataSource
        // PG: config.addDataSourceProperty(PGProperty.USER.getName(), getDbUser());
        // PG: config.addDataSourceProperty(PGProperty.PASSWORD.getName(), getDbPassword());
        // PG: The PGSimpleDataSource class seems not to have these properties (names), therefore
        // PG: below as proper hardcoded strings.
        // PG: config.addDataSourceProperty(PGProperty.PG_HOST.getName(), getDbHost());
        // PG: config.addDataSourceProperty(PGProperty.PG_PORT.getName(), getDbPort());
        // PG: config.addDataSourceProperty(PGProperty.PG_DBNAME.getName(), getDbName());
        // PG: config.addDataSourceProperty("databaseName", getDbName());
        // PG: config.addDataSourceProperty("portNumber", getDbPort());
        // PG: config.addDataSourceProperty("serverName", getDbHost());
        config.addDataSourceProperty("url", buildMySqlDbUrl());

        getDsProperties().forEach((k, v) ->
            config.addDataSourceProperty(k, String.valueOf(v))
        );
        return config;
    }

    public Optional<String> maybeGetPoolName() {
        return Optional.ofNullable(poolName);
    }

}
