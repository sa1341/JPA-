package com.jpa.jpatest.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Order {

    @Id
    @Column(name = "order_id")
    private String id;

    //주문명
    private String name;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;


    public void setMember(Member member) {

        if(this.member != null){
            this.member.getOrders().remove(this);
        }

        this.member = member;
        member.getOrders().add(this);
    }
}
