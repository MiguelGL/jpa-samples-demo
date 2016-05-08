/**
 * This class is generated by jOOQ
 */
package com.mgl.jpa.mapping.samples.jooq.tables;


import com.mgl.jpa.mapping.samples.jooq.Jpa;
import com.mgl.jpa.mapping.samples.jooq.Keys;
import com.mgl.jpa.mapping.samples.jooq.tables.records.DocumentAuthorRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
public class DocumentAuthor extends TableImpl<DocumentAuthorRecord> {

    private static final long serialVersionUID = 311797399;

    /**
     * The reference instance of <code>jpa.Document_Author</code>
     */
    public static final DocumentAuthor DOCUMENT_AUTHOR = new DocumentAuthor();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DocumentAuthorRecord> getRecordType() {
        return DocumentAuthorRecord.class;
    }

    /**
     * The column <code>jpa.Document_Author.documentId</code>.
     */
    public final TableField<DocumentAuthorRecord, Long> DOCUMENTID = createField("documentId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>jpa.Document_Author.authorId</code>.
     */
    public final TableField<DocumentAuthorRecord, Long> AUTHORID = createField("authorId", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>jpa.Document_Author</code> table reference
     */
    public DocumentAuthor() {
        this("Document_Author", null);
    }

    /**
     * Create an aliased <code>jpa.Document_Author</code> table reference
     */
    public DocumentAuthor(String alias) {
        this(alias, DOCUMENT_AUTHOR);
    }

    private DocumentAuthor(String alias, Table<DocumentAuthorRecord> aliased) {
        this(alias, aliased, null);
    }

    private DocumentAuthor(String alias, Table<DocumentAuthorRecord> aliased, Field<?>[] parameters) {
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
    public List<UniqueKey<DocumentAuthorRecord>> getKeys() {
        return Arrays.<UniqueKey<DocumentAuthorRecord>>asList(Keys.KEY_DOCUMENT_AUTHOR_DOCUMENT_AUTHOR__DOCUMENTID_AUTHORID_UIDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<DocumentAuthorRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<DocumentAuthorRecord, ?>>asList(Keys.FKQED3CIVAH38K329W66ILWS6K7, Keys.FK7BQOFSQD1N5TPAKBTNWC58X5F);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DocumentAuthor as(String alias) {
        return new DocumentAuthor(alias, this);
    }

    /**
     * Rename this table
     */
    public DocumentAuthor rename(String name) {
        return new DocumentAuthor(name, null);
    }
}