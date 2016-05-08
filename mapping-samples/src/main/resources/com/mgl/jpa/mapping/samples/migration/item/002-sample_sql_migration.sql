--liquibase formatted sql

--changeset miguel.garcia.lopez@gmail.com:001-SampleSqlMigration dbms:mysql
create table DeletemeSqlLiquibaseSample (
    sampleColumn varchar(32) not null default ''
);
