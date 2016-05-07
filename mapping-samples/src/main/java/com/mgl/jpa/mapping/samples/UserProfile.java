package com.mgl.jpa.mapping.samples;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.mgl.jpa.mapping.samples.contact.ContactInformation;
import com.mgl.jpa.mapping.samples.contact.HasContactInformation;
import com.mgl.jpa.mapping.samples.logicaldelete.LogicallyDeletableBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Delegate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(
    indexes = {
        @Index(name = "user_profile__userKind_idx", columnList = "userKind"),
        @Index(name = "user_profile__firstName_lastName_idx", columnList = "firstName, lastName"),
        @Index(name = "user_profile__deleted_idx", columnList = "deleted")
    },
    uniqueConstraints = {
        @UniqueConstraint(name = "user_profile__email_uidx", columnNames = "email")
    }
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "userKind")
@SQLDelete(sql =
        "update UserProfile "
        + "set deleted = true, deletionTs = CURRENT_TIMESTAMP "
        + "where id = ? and version = ?")
@Where(clause = "not deleted")
@Getter @Setter @ToString(callSuper = true) @NoArgsConstructor
public abstract class UserProfile extends LogicallyDeletableBaseEntity implements HasContactInformation {

    private static final long serialVersionUID = 1L;

    @NotNull
    @ManyToOne(optional = false)
    private Company company;

    @OneToOne(optional = true, mappedBy = "userProfile")
    private Avatar avatar;

    @Delegate(types = {HasContactInformation.class})
    @Embedded @NotNull
    private ContactInformation contactInformation = new ContactInformation();

}
