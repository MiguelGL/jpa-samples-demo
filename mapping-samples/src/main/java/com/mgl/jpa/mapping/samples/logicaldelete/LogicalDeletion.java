package com.mgl.jpa.mapping.samples.logicaldelete;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Embeddable
@Getter @Setter(AccessLevel.PROTECTED) @ToString
@EqualsAndHashCode
public class LogicalDeletion implements Serializable, IsLogicallyDeletable {

    private static final long serialVersionUID = 1L;

    @NotNull @Column(nullable = false) @ColumnDefault("false")
    private boolean deleted = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date deletionTs;

    public void onPersistOrUpdate() {
        if (isDeleted()) {
            if (getDeletionTs() == null) {
                throw new ValidationException("Must have a deletion ts if deleted");
            }
        } else {
            if (getDeletionTs() != null) {
                throw new ValidationException("Cannot have a deletion ts if not deleted");
            }
        }
    }

}
