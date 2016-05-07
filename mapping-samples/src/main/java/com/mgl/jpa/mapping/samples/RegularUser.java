package com.mgl.jpa.mapping.samples;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("r")
@Getter @Setter @ToString(callSuper = true) @NoArgsConstructor
public class RegularUser extends UserProfile {

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date signUpTs;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RegistrationSource registrationSource;

}
