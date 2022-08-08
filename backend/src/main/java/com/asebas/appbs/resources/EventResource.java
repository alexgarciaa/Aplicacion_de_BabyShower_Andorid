package com.asebas.appbs.resources;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asebas.appbs.domain.Event;
import com.asebas.appbs.services.EventService;

@RestController
@RequestMapping("/api/event")
public class EventResource {

    @Autowired
    private EventService eventService;

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") Integer id) {
        Event event = eventService.getEventById(id);

        return new ResponseEntity<Event>(event, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Event> addEvent(@RequestBody Map<String, Object> eventMap) {
        String direccion = (String) eventMap.get("direccion");
        String fecha = (String) eventMap.get("fecha");
        Integer bebeId = (Integer) eventMap.get("bebeId");

        Event event = eventService.addEvent(direccion, fecha, bebeId);

        return new ResponseEntity<Event>(event, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> updateEvent(@PathVariable("id") Integer id,
            @RequestBody Map<String, Object> eventMap) {
        String direccion = (String) eventMap.get("direccion");
        String fecha = (String) eventMap.get("fecha");
        Integer bebeId = (Integer) eventMap.get("bebeId");

        eventService.updateEvent(id, direccion, fecha, bebeId);

        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
