/**
 * This class is generated by jOOQ
 */
package com.mgl.jpa.mapping.samples.jooq.tables.pojos;


import java.io.Serializable;

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
public class EnterpriseuserPermission implements Serializable {

    private static final long serialVersionUID = 1434729485;

    private Long   enterpriseuser;
    private String permission;

    public EnterpriseuserPermission() {}

    public EnterpriseuserPermission(EnterpriseuserPermission value) {
        this.enterpriseuser = value.enterpriseuser;
        this.permission = value.permission;
    }

    public EnterpriseuserPermission(
        Long   enterpriseuser,
        String permission
    ) {
        this.enterpriseuser = enterpriseuser;
        this.permission = permission;
    }

    public Long getEnterpriseuser() {
        return this.enterpriseuser;
    }

    public void setEnterpriseuser(Long enterpriseuser) {
        this.enterpriseuser = enterpriseuser;
    }

    public String getPermission() {
        return this.permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("EnterpriseuserPermission (");

        sb.append(enterpriseuser);
        sb.append(", ").append(permission);

        sb.append(")");
        return sb.toString();
    }
}
