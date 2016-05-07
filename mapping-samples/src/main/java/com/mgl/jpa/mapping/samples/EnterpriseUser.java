package com.mgl.jpa.mapping.samples;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.mgl.jpa.mapping.samples.logicaldelete.IsLogicallyDeletable;
import com.mgl.jpa.mapping.samples.logicaldelete.LogicalDeletion;
import com.mgl.jpa.mapping.samples.tscontrol.HasTsControlFields;
import com.mgl.jpa.mapping.samples.tscontrol.TsControlFields;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Delegate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(indexes = {
    @Index(name = "enterprise_user__deleted_idx", columnList = "deleted")
})
@DiscriminatorValue("e")
@SQLDelete(sql =
        "update EnterpriseUser "
        + "set deleted = true, deletionTs = CURRENT_TIMESTAMP "
        + "where id = ?")
@Where(clause = "not deleted")
@Getter @Setter @ToString(callSuper = true) @NoArgsConstructor
public class EnterpriseUser extends UserProfile implements HasTsControlFields, IsLogicallyDeletable {

    private static final long serialVersionUID = 1L;

    private static final int PERMISSION_MAX_LEN = 32;

    @NotNull
    @Embedded
    @Delegate(types = {HasTsControlFields.class})
    @Getter(AccessLevel.PROTECTED) @Setter(AccessLevel.PROTECTED)
    private TsControlFields tsControlFields = new TsControlFields();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date signUpTs;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RegistrationSource registrationSource;

    @Embedded @NotNull
    @Delegate(types = {IsLogicallyDeletable.class})
    private LogicalDeletion deleteSupport = new LogicalDeletion();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "EnterpriseUser_Permission",
            indexes = @Index(columnList = "permission"),
            joinColumns = @JoinColumn(name = "enterpriseUser"),
            uniqueConstraints = @UniqueConstraint(
                    name = "EnterpriseUser_Permission__enterpriseUser_permission_uidx",
                    columnNames = {"enterpriseUser", "permission"}))
    @Column(name = "permission", nullable = false, length = PERMISSION_MAX_LEN)
    private List<String> permissions;

    @PrePersist
    public void onPersist() {
        getTsControlFields().onPersist();
    }

    @PreUpdate
    public void onUpdate() {
        getTsControlFields().onUpdate();
    }

}
