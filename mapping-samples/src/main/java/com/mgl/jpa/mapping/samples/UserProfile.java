package com.mgl.jpa.mapping.samples;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.mgl.jpa.mapping.samples.contact.ContactInformation;
import com.mgl.jpa.mapping.samples.support.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString @NoArgsConstructor
public class UserProfile extends BaseEntity {

    @Embedded
    private ContactInformation contactInformation = new ContactInformation();

}
