package com.mgl.jpa.mapping.samples.tscontrol;

import com.mgl.jpa.mapping.samples.support.BaseEntity;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Delegate;

@MappedSuperclass
@Getter @Setter(AccessLevel.PROTECTED) @ToString(callSuper = true) @NoArgsConstructor
public abstract class TsControlledEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Embedded
    @Delegate(types = {HasTsControlFields.class})
    private TsControlFields tsControlFields = new TsControlFields();

    @PrePersist
    public void onPersist() {
        getTsControlFields().onPersist();
    }

    @PreUpdate
    public void onUpdate() {
        getTsControlFields().onUpdate();
    }

}
