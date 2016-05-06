package com.mgl.jpa.mapping.samples.contact;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Address implements Serializable {

    @NotNull
    private String street;

    @NotNull
    private String city;

}
