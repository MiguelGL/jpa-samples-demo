/**
 * This class is generated by jOOQ
 */
package com.mgl.jpa.mapping.samples.jooq;


import com.mgl.jpa.mapping.samples.jooq.tables.Avatar;
import com.mgl.jpa.mapping.samples.jooq.tables.Company;
import com.mgl.jpa.mapping.samples.jooq.tables.Document;
import com.mgl.jpa.mapping.samples.jooq.tables.DocumentAuthor;
import com.mgl.jpa.mapping.samples.jooq.tables.Enterpriseuser;
import com.mgl.jpa.mapping.samples.jooq.tables.EnterpriseuserPermission;
import com.mgl.jpa.mapping.samples.jooq.tables.Regularuser;
import com.mgl.jpa.mapping.samples.jooq.tables.Userprofile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Jpa extends SchemaImpl {

    private static final long serialVersionUID = 1695168265;

    /**
     * The reference instance of <code>jpa</code>
     */
    public static final Jpa JPA = new Jpa();

    /**
     * The table <code>jpa.Avatar</code>.
     */
    public final Avatar AVATAR = com.mgl.jpa.mapping.samples.jooq.tables.Avatar.AVATAR;

    /**
     * The table <code>jpa.Company</code>.
     */
    public final Company COMPANY = com.mgl.jpa.mapping.samples.jooq.tables.Company.COMPANY;

    /**
     * The table <code>jpa.Document</code>.
     */
    public final Document DOCUMENT = com.mgl.jpa.mapping.samples.jooq.tables.Document.DOCUMENT;

    /**
     * The table <code>jpa.Document_Author</code>.
     */
    public final DocumentAuthor DOCUMENT_AUTHOR = com.mgl.jpa.mapping.samples.jooq.tables.DocumentAuthor.DOCUMENT_AUTHOR;

    /**
     * The table <code>jpa.EnterpriseUser</code>.
     */
    public final Enterpriseuser ENTERPRISEUSER = com.mgl.jpa.mapping.samples.jooq.tables.Enterpriseuser.ENTERPRISEUSER;

    /**
     * The table <code>jpa.EnterpriseUser_Permission</code>.
     */
    public final EnterpriseuserPermission ENTERPRISEUSER_PERMISSION = com.mgl.jpa.mapping.samples.jooq.tables.EnterpriseuserPermission.ENTERPRISEUSER_PERMISSION;

    /**
     * The table <code>jpa.RegularUser</code>.
     */
    public final Regularuser REGULARUSER = com.mgl.jpa.mapping.samples.jooq.tables.Regularuser.REGULARUSER;

    /**
     * The table <code>jpa.UserProfile</code>.
     */
    public final Userprofile USERPROFILE = com.mgl.jpa.mapping.samples.jooq.tables.Userprofile.USERPROFILE;

    /**
     * No further instances allowed
     */
    private Jpa() {
        super("jpa", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Avatar.AVATAR,
            Company.COMPANY,
            Document.DOCUMENT,
            DocumentAuthor.DOCUMENT_AUTHOR,
            Enterpriseuser.ENTERPRISEUSER,
            EnterpriseuserPermission.ENTERPRISEUSER_PERMISSION,
            Regularuser.REGULARUSER,
            Userprofile.USERPROFILE);
    }
}
