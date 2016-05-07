package com.mgl.jpa.mapping.samples;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.mgl.jpa.mapping.samples.support.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Getter @Setter @ToString(callSuper = true, exclude = {"userProfile"}) @NoArgsConstructor
public class Avatar extends BaseEntity {

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
