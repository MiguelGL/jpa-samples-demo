package com.mgl.jpa.mapping.samples.support;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@MappedSuperclass
@Getter @Setter(AccessLevel.PROTECTED) @ToString(callSuper = true) @NoArgsConstructor
public abstract class TsControlledEntity extends BaseEntity {

    @NotNull
    @Temporal(TemporalType.TIMESTAMP) @Column(nullable = false) @ColumnDefault("CURRENT_TIMESTAMP")
    private Date creationTs;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP) @Column(nullable = false) @ColumnDefault("CURRENT_TIMESTAMP")
    private Date lastModificationTs;

    @PrePersist
    public void onPersist() {
        Date ts = new Date();
        setCreationTs(ts);
        setLastModificationTs(ts);
    }

    @PreUpdate
    public void onUpdate() {
        Date ts = new Date();
        if (getCreationTs() == null) {
            setCreationTs(ts);
        }
        setLastModificationTs(ts);
    }

}
