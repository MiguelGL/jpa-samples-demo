package com.mgl.jpa.mapping.samples;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.mgl.jpa.mapping.samples.tscontrol.HasTsControlFields;
import com.mgl.jpa.mapping.samples.tscontrol.TsControlFields;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Delegate;

@Entity
@DiscriminatorValue("e")
@Getter @Setter @ToString(callSuper = true) @NoArgsConstructor
public class EnterpriseUser extends UserProfile implements HasTsControlFields {

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

    @PrePersist
    public void onPersist() {
        getTsControlFields().onPersist();
    }

    @PreUpdate
    public void onUpdate() {
        getTsControlFields().onUpdate();
    }

}
