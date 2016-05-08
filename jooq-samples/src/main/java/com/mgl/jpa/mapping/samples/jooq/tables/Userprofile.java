/**
 * This class is generated by jOOQ
 */
package com.mgl.jpa.mapping.samples.jooq.tables;


import com.mgl.jpa.mapping.samples.jooq.Jpa;
import com.mgl.jpa.mapping.samples.jooq.Keys;
import com.mgl.jpa.mapping.samples.jooq.tables.records.UserprofileRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class Userprofile extends TableImpl<UserprofileRecord> {

    private static final long serialVersionUID = 2056689221;

    /**
     * The reference instance of <code>jpa.UserProfile</code>
     */
    public static final Userprofile USERPROFILE = new Userprofile();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserprofileRecord> getRecordType() {
        return UserprofileRecord.class;
    }

    /**
     * The column <code>jpa.UserProfile.userKind</code>.
     */
    public final TableField<UserprofileRecord, String> USERKIND = createField("userKind", org.jooq.impl.SQLDataType.VARCHAR.length(31).nullable(false), this, "");

    /**
     * The column <code>jpa.UserProfile.id</code>.
     */
    public final TableField<UserprofileRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>jpa.UserProfile.version</code>.
     */
    public final TableField<UserprofileRecord, Long> VERSION = createField("version", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>jpa.UserProfile.city</code>.
     */
    public final TableField<UserprofileRecord, String> CITY = createField("city", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false).defaultValue(org.jooq.impl.DSL.field("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>jpa.UserProfile.street</code>.
     */
    public final TableField<UserprofileRecord, String> STREET = createField("street", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false).defaultValue(org.jooq.impl.DSL.field("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>jpa.UserProfile.email</code>.
     */
    public final TableField<UserprofileRecord, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false), this, "");

    /**
     * The column <code>jpa.UserProfile.firstName</code>.
     */
    public final TableField<UserprofileRecord, String> FIRSTNAME = createField("firstName", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false).defaultValue(org.jooq.impl.DSL.field("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>jpa.UserProfile.lastName</code>.
     */
    public final TableField<UserprofileRecord, String> LASTNAME = createField("lastName", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false).defaultValue(org.jooq.impl.DSL.field("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>jpa.UserProfile.company_id</code>.
     */
    public final TableField<UserprofileRecord, Long> COMPANY_ID = createField("company_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>jpa.UserProfile</code> table reference
     */
    public Userprofile() {
        this("UserProfile", null);
    }

    /**
     * Create an aliased <code>jpa.UserProfile</code> table reference
     */
    public Userprofile(String alias) {
        this(alias, USERPROFILE);
    }

    private Userprofile(String alias, Table<UserprofileRecord> aliased) {
        this(alias, aliased, null);
    }

    private Userprofile(String alias, Table<UserprofileRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Jpa.JPA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<UserprofileRecord, Long> getIdentity() {
        return Keys.IDENTITY_USERPROFILE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UserprofileRecord> getPrimaryKey() {
        return Keys.KEY_USERPROFILE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UserprofileRecord>> getKeys() {
        return Arrays.<UniqueKey<UserprofileRecord>>asList(Keys.KEY_USERPROFILE_PRIMARY, Keys.KEY_USERPROFILE_USER_PROFILE__EMAIL_UIDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<UserprofileRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UserprofileRecord, ?>>asList(Keys.FK5GU1O4X2CAOFNE9NDBG001YYW);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TableField<UserprofileRecord, Long> getRecordVersion() {
        return VERSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Userprofile as(String alias) {
        return new Userprofile(alias, this);
    }

    /**
     * Rename this table
     */
    public Userprofile rename(String name) {
        return new Userprofile(name, null);
    }
}
