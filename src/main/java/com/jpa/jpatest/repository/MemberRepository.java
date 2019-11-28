package com.jpa.jpatest.repository;

import com.jpa.jpatest.domain.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {

    @EntityGraph("memberWithTeam")
    @Query("select m from Member m")
    public List<Member> getMembersWithTeam();
}
