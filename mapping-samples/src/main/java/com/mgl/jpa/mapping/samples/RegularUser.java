package com.mgl.jpa.mapping.samples;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.mgl.jpa.mapping.samples.logicaldelete.IsLogicallyDeletable;
import com.mgl.jpa.mapping.samples.logicaldelete.LogicalDeletion;
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
        @Index(name = "regular_user__registrationSource_idx", columnList = "registrationSource"),
        @Index(name = "regular_user__signupTs_idx", columnList = "signUpTs"),
        @Index(name = "regular_user__deleted_idx", columnList = "deleted")
    }
)
@DiscriminatorValue("r")
@SQLDelete(sql =
        "update RegularUser "
        + "set deleted = true, deletionTs = CURRENT_TIMESTAMP "
        + "where id = ?")
@Where(clause = "not deleted")
@Getter @Setter @ToString(callSuper = true, exclude = {"documents"}) @NoArgsConstructor
public class RegularUser extends UserProfile implements IsLogicallyDeletable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP) @Column(nullable = false)
    private Date signUpTs;

    @NotNull
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private RegistrationSource registrationSource;

    @Embedded @NotNull
    @Delegate(types = {IsLogicallyDeletable.class})
    private LogicalDeletion deleteSupport = new LogicalDeletion();

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
    @Where(clause = "not deleted")
    private List<Document> documents;

}
