package com.jpa.jpatest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Getter
@Setter
public class Address {

    private String city;
    private String street;

    @Embedded
    private Zipcode zipcode;


}
