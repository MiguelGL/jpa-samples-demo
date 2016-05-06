package com.mgl.jpa.mapping.samples.contact;

public interface HasContactInformation {

    static final int EMAIL_MIN_LEN = 3;
    static final int EMAIL_MAX_LEN = 64;

    static final int FIRST_NAME_MIN_LEN = 0;
    static final int FIRST_NAME_MAX_LEN = 64;

    static final int LAST_NAME_MIN_LEN = 0;
    static final int LAST_NAME_MAX_LEN = 64;

    String getEmail();
    void setEmail(String email);

    String getFirstName();
    void setFirstName(String firstName);

    String getLastName();
    void setLastName(String lastName);

    Address getAddress();
    void setAddress(Address address);

}
