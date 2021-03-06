/**
 * This class is generated by jOOQ
 */
package com.mgl.jpa.mapping.samples.jooq.tables.records;


import com.mgl.jpa.mapping.samples.jooq.tables.Enterpriseuser;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EnterpriseuserRecord extends UpdatableRecordImpl<EnterpriseuserRecord> implements Record5<String, Timestamp, Timestamp, Timestamp, Long> {

    private static final long serialVersionUID = -1240345914;

    /**
     * Setter for <code>jpa.EnterpriseUser.registrationSource</code>.
     */
    public void setRegistrationsource(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>jpa.EnterpriseUser.registrationSource</code>.
     */
    public String getRegistrationsource() {
        return (String) get(0);
    }

    /**
     * Setter for <code>jpa.EnterpriseUser.signUpTs</code>.
     */
    public void setSignupts(Timestamp value) {
        set(1, value);
    }

    /**
     * Getter for <code>jpa.EnterpriseUser.signUpTs</code>.
     */
    public Timestamp getSignupts() {
        return (Timestamp) get(1);
    }

    /**
     * Setter for <code>jpa.EnterpriseUser.creationTs</code>.
     */
    public void setCreationts(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>jpa.EnterpriseUser.creationTs</code>.
     */
    public Timestamp getCreationts() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>jpa.EnterpriseUser.lastModificationTs</code>.
     */
    public void setLastmodificationts(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>jpa.EnterpriseUser.lastModificationTs</code>.
     */
    public Timestamp getLastmodificationts() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>jpa.EnterpriseUser.id</code>.
     */
    public void setId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>jpa.EnterpriseUser.id</code>.
     */
    public Long getId() {
        return (Long) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, Timestamp, Timestamp, Timestamp, Long> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, Timestamp, Timestamp, Timestamp, Long> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Enterpriseuser.ENTERPRISEUSER.REGISTRATIONSOURCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field2() {
        return Enterpriseuser.ENTERPRISEUSER.SIGNUPTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return Enterpriseuser.ENTERPRISEUSER.CREATIONTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return Enterpriseuser.ENTERPRISEUSER.LASTMODIFICATIONTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return Enterpriseuser.ENTERPRISEUSER.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getRegistrationsource();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value2() {
        return getSignupts();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getCreationts();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getLastmodificationts();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value5() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnterpriseuserRecord value1(String value) {
        setRegistrationsource(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnterpriseuserRecord value2(Timestamp value) {
        setSignupts(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnterpriseuserRecord value3(Timestamp value) {
        setCreationts(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnterpriseuserRecord value4(Timestamp value) {
        setLastmodificationts(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnterpriseuserRecord value5(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnterpriseuserRecord values(String value1, Timestamp value2, Timestamp value3, Timestamp value4, Long value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached EnterpriseuserRecord
     */
    public EnterpriseuserRecord() {
        super(Enterpriseuser.ENTERPRISEUSER);
    }

    /**
     * Create a detached, initialised EnterpriseuserRecord
     */
    public EnterpriseuserRecord(String registrationsource, Timestamp signupts, Timestamp creationts, Timestamp lastmodificationts, Long id) {
        super(Enterpriseuser.ENTERPRISEUSER);

        set(0, registrationsource);
        set(1, signupts);
        set(2, creationts);
        set(3, lastmodificationts);
        set(4, id);
    }
}
