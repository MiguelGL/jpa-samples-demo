package com.mgl.jpa.mapping.samples.logicaldelete;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import com.mgl.jpa.mapping.samples.support.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Delegate;

@MappedSuperclass
@Getter @Setter(AccessLevel.PROTECTED) @ToString(callSuper = true) @NoArgsConstructor
public abstract class LogicallyDeletableBaseEntity extends BaseEntity implements IsLogicallyDeletable {

    private static final long serialVersionUID = 1L;

    @Embedded @NotNull
    @Delegate(types = {IsLogicallyDeletable.class})
    private LogicalDeletion deleteSupport = new LogicalDeletion();

    @PrePersist @PreUpdate
    public void onPersistOrUpdate() {
        getDeleteSupport().onPersistOrUpdate();
    }

}
