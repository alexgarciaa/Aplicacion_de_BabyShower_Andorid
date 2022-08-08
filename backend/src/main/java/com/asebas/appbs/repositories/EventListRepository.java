package com.asebas.appbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asebas.appbs.domain.EventList;

@Repository
public interface EventListRepository extends JpaRepository<EventList, Integer> {

}
