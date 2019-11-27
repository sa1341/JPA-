package com.jpa.jpatest.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Zipcode {

    private String zip;
    private String plusFour;

}
