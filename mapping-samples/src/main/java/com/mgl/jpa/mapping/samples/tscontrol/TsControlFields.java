package com.mgl.jpa.mapping.samples.tscontrol;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Data @Setter(AccessLevel.PROTECTED)
public class TsControlFields implements HasTsControlFields {

    @NotNull
    @Temporal(TemporalType.TIMESTAMP) @Column(nullable = false) @ColumnDefault("CURRENT_TIMESTAMP")
    private Date creationTs;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP) @Column(nullable = false) @ColumnDefault("CURRENT_TIMESTAMP")
    private Date lastModificationTs;

    public void onPersist() {
        Date ts = new Date();
        setCreationTs(ts);
        setLastModificationTs(ts);
    }

    public void onUpdate() {
        Date ts = new Date();
        if (getCreationTs() == null) {
            setCreationTs(ts);
        }
        setLastModificationTs(ts);
    }

}
