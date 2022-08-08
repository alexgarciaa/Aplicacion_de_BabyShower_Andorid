package com.asebas.appbs.services;

import com.asebas.appbs.domain.EventList;
import com.asebas.appbs.exceptions.CBadRequestException;
import com.asebas.appbs.exceptions.CResourceNotFoundException;

public interface EventListService {
    
    EventList getEventListById(Integer id) throws CResourceNotFoundException;

    EventList addEventList(Integer eventoId, Double precioTotal) throws CBadRequestException;

    void updatEventList(Integer id, EventList eventList) throws CBadRequestException;
}
