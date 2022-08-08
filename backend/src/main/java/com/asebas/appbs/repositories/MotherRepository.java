package com.asebas.appbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asebas.appbs.domain.Mother;

@Repository
public interface MotherRepository extends JpaRepository<Mother, Integer> {
    
    Mother findByEmail(String email);
}
