package com.mgl.jpa.mapping.samples;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.mgl.jpa.mapping.samples.contact.ContactInformation;
import com.mgl.jpa.mapping.samples.contact.HasContactInformation;
import com.mgl.jpa.mapping.samples.support.TsControlledEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Delegate;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Getter @Setter @ToString(callSuper = true) @NoArgsConstructor
public class UserProfile extends TsControlledEntity implements HasContactInformation {

    @NotNull
    @ManyToOne(optional = false)
    private Company company;

    @OneToOne(optional = true, mappedBy = "userProfile")
    private Avatar avatar;

    @Delegate(types = {HasContactInformation.class})
    @Embedded @NotNull
    private ContactInformation contactInformation = new ContactInformation();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date signUpTs;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RegistrationSource registrationSource;

}
