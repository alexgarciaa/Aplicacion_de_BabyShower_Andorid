package com.asebas.appbs.services;

import com.asebas.appbs.domain.Event;
import com.asebas.appbs.exceptions.CBadRequestException;
import com.asebas.appbs.exceptions.CResourceNotFoundException;

public interface EventService {

    Event getEventById(Integer id) throws CResourceNotFoundException;

    Event addEvent(String direccion, String fecha, Integer bebeId) throws CBadRequestException;

    void updateEvent(Integer id, String direccion, String fecha, Integer bebeId) throws CBadRequestException;

}
