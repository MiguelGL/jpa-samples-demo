/**
 * This class is generated by jOOQ
 */
package com.mgl.jpa.mapping.samples.jooq.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


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
public class Regularuser implements Serializable {

    private static final long serialVersionUID = 1778213312;

    private String    registrationsource;
    private Timestamp signupts;
    private Long      id;

    public Regularuser() {}

    public Regularuser(Regularuser value) {
        this.registrationsource = value.registrationsource;
        this.signupts = value.signupts;
        this.id = value.id;
    }

    public Regularuser(
        String    registrationsource,
        Timestamp signupts,
        Long      id
    ) {
        this.registrationsource = registrationsource;
        this.signupts = signupts;
        this.id = id;
    }

    public String getRegistrationsource() {
        return this.registrationsource;
    }

    public void setRegistrationsource(String registrationsource) {
        this.registrationsource = registrationsource;
    }

    public Timestamp getSignupts() {
        return this.signupts;
    }

    public void setSignupts(Timestamp signupts) {
        this.signupts = signupts;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Regularuser (");

        sb.append(registrationsource);
        sb.append(", ").append(signupts);
        sb.append(", ").append(id);

        sb.append(")");
        return sb.toString();
    }
}
