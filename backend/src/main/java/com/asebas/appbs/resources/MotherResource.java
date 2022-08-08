package com.asebas.appbs.resources;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import com.asebas.appbs.domain.Mother;
import com.asebas.appbs.services.MotherService;

@RestController
@RequestMapping("/api/mother")
public class MotherResource {

    @Autowired
    private MotherService motherService;

    @GetMapping("/{id}")
    public ResponseEntity<Mother> getMotherById(@PathVariable("id") Integer id) {
        Mother mother = motherService.getMotherById(id);

        return new ResponseEntity<>(mother, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Mother> addMother(HttpServletRequest request, @RequestBody Mother mother) {
        Integer userId = (Integer) request.getAttribute("userId");
        Mother newMother = motherService.addMother(userId, mother);

        return new ResponseEntity<>(newMother, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> updateMother(@PathVariable("id") Integer id, @RequestBody Mother mother) {
        motherService.updateMother(id, mother);

        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
