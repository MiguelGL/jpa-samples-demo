package com.mgl.jpa.mapping.samples.contact;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
public class Address implements Serializable {

    private static final int STREET_MIN_LEN = 0;
    private static final int STREET_MAX_LEN = 64;

    private static final int CITY_MIN_LEN = 0;
    private static final int CITY_MAX_LEN = 64;

    @NotNull @Size(min = STREET_MIN_LEN, max = STREET_MAX_LEN)
    @Column(nullable = false, length = STREET_MAX_LEN) @ColumnDefault("''")
    private String street = "";

    @NotNull @Size(min = CITY_MIN_LEN, max = CITY_MAX_LEN)
    @Column(nullable = false, length = CITY_MAX_LEN) @ColumnDefault("''")
    private String city = "";

}
