package com.jpa.jpatest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Setter
@Getter
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "book_id")
public class Book extends Item {

    private String author;
    private String isbn;
}
