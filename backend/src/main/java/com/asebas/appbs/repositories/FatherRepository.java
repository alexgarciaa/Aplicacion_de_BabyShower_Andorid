package com.asebas.appbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asebas.appbs.domain.Father;

@Repository
public interface FatherRepository extends JpaRepository<Father, Integer> {

    Father findByEmail(String email);
}
