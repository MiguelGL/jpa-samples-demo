package com.mgl.jpa.mapping.samples;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(
    indexes = {
        @Index(name = "regular_user__registrationSource_idx", columnList = "registrationSource"),
        @Index(name = "regular_user__signupTs_idx", columnList = "signUpTs")
    }
)
@DiscriminatorValue("r")
@Getter @Setter @ToString(callSuper = true) @NoArgsConstructor
public class RegularUser extends UserProfile {

    @NotNull
    @Temporal(TemporalType.TIMESTAMP) @Column(nullable = false)
    private Date signUpTs;

    @NotNull
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private RegistrationSource registrationSource;

    @ManyToMany(mappedBy = "authors")
//    @JoinTable(
//        name = "Document_RegularUser",
//        joinColumns = @JoinColumn(name = "authorId", referencedColumnName = "id"),
//        inverseJoinColumns = @JoinColumn(name = "documentId", referencedColumnName = "id"),
//        uniqueConstraints = {
//            @UniqueConstraint(
//                name = "document_regular_user__documentId_authorId_uidx",
//                columnNames = {"documentId", "authorId"})
//        }
//    )
    private List<Document> documents;

}
