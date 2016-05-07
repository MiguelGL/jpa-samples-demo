package com.mgl.jpa.mapping.samples;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("l")
@Getter @Setter @ToString(callSuper = true) @NoArgsConstructor
public class LocalDocument extends Document {

    private static final int PATH_MIN_LEN = 2;
    private static final int PATH_MAX_LEN = 128;

    @NotNull @Size(min = PATH_MIN_LEN, max = PATH_MAX_LEN)
    @Column(nullable = /* false */ true /* single table inheritance! */, length = PATH_MAX_LEN)
    private String filePath;

}
