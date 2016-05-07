package com.mgl.jpa.mapping.samples;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.mgl.jpa.mapping.samples.logicaldelete.LogicallyDeletableBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(
    indexes = {
        @Index(name = "avatar__deleted_idx", columnList = "deleted")
    }
)
@SQLDelete(sql =
        "update Avatar "
        + "set deleted = true, deletionTs = CURRENT_TIMESTAMP "
        + "where id = ? and version = ?")
@Where(clause = "not deleted")
@Getter @Setter @ToString(callSuper = true, exclude = {"userProfile"}) @NoArgsConstructor
public class Avatar extends LogicallyDeletableBaseEntity {

    private static final long serialVersionUID = 1L;

    private static final int URL_MAX_LEN = 128;

    private static final String URL_REGEX =
            "^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$";

    @NotNull
    @OneToOne(optional = false)
    private UserProfile userProfile;

    @NotNull @NotBlank @Pattern(regexp = URL_REGEX) @Size(max = URL_MAX_LEN)
    @Column(nullable = false, length = URL_MAX_LEN)
    private String url;

}
