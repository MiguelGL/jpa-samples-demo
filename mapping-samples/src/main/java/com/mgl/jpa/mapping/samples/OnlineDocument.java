package com.mgl.jpa.mapping.samples;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@DiscriminatorValue("o")
@Getter @Setter @ToString(callSuper = true) @NoArgsConstructor
public class OnlineDocument extends Document {

    private static final long serialVersionUID = 1L;

    private static final int URL_MAX_LEN = 128;

    private static final String URL_REGEX =
            "^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$";

    @NotNull @NotBlank @Pattern(regexp = URL_REGEX) @Size(max = URL_MAX_LEN)
    @Column(nullable = /* false */ true /* single table inheritance! */, length = URL_MAX_LEN)
    private String url;

}
