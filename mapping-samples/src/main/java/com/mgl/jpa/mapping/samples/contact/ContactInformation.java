package com.mgl.jpa.mapping.samples.contact;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Email;

@Data
public class ContactInformation implements HasContactInformation {

    @Email
    @NotNull @Size(min = EMAIL_MIN_LEN, max = EMAIL_MAX_LEN)
    @Column(nullable = false, length = EMAIL_MAX_LEN)
    private String email;

    @NotNull @Size(min = FIRST_NAME_MIN_LEN, max = FIRST_NAME_MAX_LEN)
    @Column(nullable = false, length = FIRST_NAME_MAX_LEN) @ColumnDefault("''")
    private String firstName = "";

    @NotNull @Size(min = LAST_NAME_MIN_LEN, max = LAST_NAME_MAX_LEN)
    @Column(nullable = false, length = LAST_NAME_MAX_LEN) @ColumnDefault("''")
    private String lastName = "";

    @NotNull
    @Embedded
    private Address address = new Address();

}
