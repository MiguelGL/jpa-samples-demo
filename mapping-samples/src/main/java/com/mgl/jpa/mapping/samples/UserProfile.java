package com.mgl.jpa.mapping.samples;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mgl.jpa.mapping.samples.contact.ContactInformation;
import com.mgl.jpa.mapping.samples.support.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Getter @Setter @ToString @NoArgsConstructor
public class UserProfile extends BaseEntity {

    @Embedded
    private ContactInformation contactInformation = new ContactInformation();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date signUpTs;

    @NotNull
    @Basic(optional = false)
    private String whatever;

    @NotNull
    @Size(max = 10)
    private String shouldNotNull;

    @NotNull
//    @Basic(optional = false)
    @Size(max = 12)
    private String shouldNotNullEither;

}
