package com.jpa.jpatest.repository;

import com.jpa.jpatest.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, String > {
}
