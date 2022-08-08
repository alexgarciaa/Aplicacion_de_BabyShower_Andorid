package com.asebas.appbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asebas.appbs.domain.Baby;

@Repository
public interface BabyRepository extends JpaRepository<Baby, Integer> {

}
