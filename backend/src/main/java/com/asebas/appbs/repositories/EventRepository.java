package com.asebas.appbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asebas.appbs.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    
}
