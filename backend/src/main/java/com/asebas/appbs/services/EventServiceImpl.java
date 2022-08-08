package com.asebas.appbs.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asebas.appbs.domain.Baby;
import com.asebas.appbs.domain.Event;
import com.asebas.appbs.exceptions.CBadRequestException;
import com.asebas.appbs.exceptions.CResourceNotFoundException;
import com.asebas.appbs.repositories.BabyRepository;
import com.asebas.appbs.repositories.EventRepository;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private BabyRepository babyRepository;

    @Override
    public Event getEventById(Integer id) throws CResourceNotFoundException {
        try {
            return eventRepository.findById(id).get();
        } catch (Exception e) {
            throw new CResourceNotFoundException("Resource not found");
        }
    }

    @Override
    public Event addEvent(String direccion, String fecha, Integer bebeId) throws CBadRequestException {
        try {
            Baby bebe = babyRepository.findById(bebeId).get();
            Event event = new Event(direccion, fecha, bebe);

            return eventRepository.save(event);
        } catch (Exception e) {
            throw new CBadRequestException("Invalid data. Failed to create");
        }
    }

    @Override
    public void updateEvent(Integer id, String direccion, String fecha, Integer bebeId) throws CBadRequestException {
        try {
            Baby bebe = babyRepository.findById(bebeId).get();

            Event existingEvent = eventRepository.findById(id).get();
            existingEvent.setDireccion(direccion);
            existingEvent.setFecha(fecha);
            existingEvent.setBebe(bebe);

            eventRepository.save(existingEvent);
        } catch (Exception e) {
            throw new CBadRequestException("Invalid data. Failed to update");
        }
    }

}
