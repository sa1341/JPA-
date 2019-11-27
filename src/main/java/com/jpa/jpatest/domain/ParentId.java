package com.jpa.jpatest.domain;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
@NoArgsConstructor
public class ParentId implements Serializable {


    @Column(name = "PARENT_ID1")
    private String id1; // Parent.id1 매핑


    @Column(name = "PARENT_ID2")
    private String id2; // Parent.id2 매핑



    public ParentId(String id1, String id2){
        this.id1 = id1;
        this.id2 = id2;
    }



}