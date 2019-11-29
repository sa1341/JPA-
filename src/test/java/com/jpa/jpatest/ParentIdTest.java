package com.jpa.jpatest;

import com.jpa.jpatest.domain.Child;
import com.jpa.jpatest.domain.Parent;
import com.jpa.jpatest.domain.ParentId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParentIdTest {

    @Autowired
    EntityManager em;



    @Test
    @Transactional
    @Rollback(false)
    public void 식별자_테스트() throws Exception {

        Parent parent = new Parent();
        parent.setName("임종수");

        Child child = new Child();
        child.setName("임준영");

        Child newChild = new Child();
        newChild.setName("임주리");
        //parent.setChild(child);
        em.persist(parent);
        em.persist(child);


     }


}
