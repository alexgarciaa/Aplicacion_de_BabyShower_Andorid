package com.asebas.appbs.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asebas.appbs.domain.Event;
import com.asebas.appbs.domain.EventList;
import com.asebas.appbs.exceptions.CBadRequestException;
import com.asebas.appbs.exceptions.CResourceNotFoundException;
import com.asebas.appbs.repositories.EventListRepository;
import com.asebas.appbs.repositories.EventRepository;

@Service
@Transactional
public class EventListServiceImpl implements EventListService {

    @Autowired
    private EventListRepository eventListRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public EventList getEventListById(Integer id) throws CResourceNotFoundException {
        try {
            return eventListRepository.findById(id).get();

        } catch (Exception e) {
            throw new CResourceNotFoundException("Resource not found");
        }
    }

    @Override
    public EventList addEventList(Integer eventoId, Double precioTotal) throws CBadRequestException {
        try {
            Event evento = eventRepository.findById(eventoId).get();

            EventList eventList = new EventList(precioTotal, evento);

            return eventListRepository.save(eventList);
        } catch (Exception e) {
            throw new CBadRequestException("Invalid data. Failed to create");
        }
    }

    @Override
    public void updatEventList(Integer id, EventList eventList) throws CBadRequestException {
        try {
            EventList existingEventList = eventListRepository.findById(id).get();

            existingEventList.setPrecioTotal(eventList.getPrecioTotal());

            eventListRepository.save(existingEventList);
        } catch (Exception e) {
            throw new CBadRequestException("Invalid data. Failed to update");
        }
    }

}
