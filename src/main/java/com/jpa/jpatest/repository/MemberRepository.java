package com.jpa.jpatest.repository;

import com.jpa.jpatest.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
