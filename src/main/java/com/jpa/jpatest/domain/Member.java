package com.jpa.jpatest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Member {

    @Id
    @Column(name = "member_id")
    private String id;

    private String name;

    private int age;

    @Embedded
    private Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "COMPANY_CITY")),
            @AttributeOverride(name = "street", column= @Column(name = "COMPANY_STREET")),
            @AttributeOverride(name = "zipcode", column= @Column(name = "COMPANY_ZIPCODE"))
    })
    private Address companyAddress;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY)
    List<Order> orders = new ArrayList<Order>();



    //연관관계 편의 메소드 : 연관관계를 변경할 때는 기존 팀이 있으면 기존 팀과 회원의 연관관계를 삭제하는 코드를 추가해야합니다.
    public void setTeam(Team team){
        if(this.team != null){
            this.team.getMembers().remove(this);
        }
        this.team = team;
        team.getMembers().add(this);
    }
}
