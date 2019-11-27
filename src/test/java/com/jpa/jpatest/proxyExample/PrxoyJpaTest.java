package com.jpa.jpatest.proxyExample;

import com.jpa.jpatest.domain.*;
import com.jpa.jpatest.repository.MemberRepository;
import com.jpa.jpatest.repository.OrderRepository;
import com.jpa.jpatest.repository.TeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrxoyJpaTest {


    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    EntityManager entityManager;

    @Autowired
    OrderRepository orderRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void printUser() throws Exception {


        // 1번 자식 저장
        Child child1 = new Child();
        // 2번 자식 저장
        Child child2 = new Child();

        Parent parent = new Parent();
        parent.setName("임종수");
        child1.setName("임준영");
        child2.setName("임주리");
        child1.setParent(parent); // 자식 -> 부모 연관관계 설정
        child2.setParent(parent); // 자식 -> 부모 연관관계 설정
        parent.getChildren().add(child1); // 부모 -> 자식
        parent.getChildren().add(child2); // 부모 -> 자식

        // 부모 저장
        entityManager.persist(parent);

        parent.getChildren().clear();
    }





}
