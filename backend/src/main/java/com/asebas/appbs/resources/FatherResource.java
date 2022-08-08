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

import com.asebas.appbs.domain.Father;
import com.asebas.appbs.services.FatherService;

@RestController
@RequestMapping("/api/father")
public class FatherResource {

    @Autowired
    private FatherService fatherService;

    @GetMapping("/{id}")
    public ResponseEntity<Father> getFatherById(@PathVariable("id") Integer id) {
        Father father = fatherService.getFatherById(id);
        
        return new ResponseEntity<>(father, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Father> addFather(HttpServletRequest request, @RequestBody Father father) {
        Integer userId = (Integer) request.getAttribute("userId");
        Father newFather = fatherService.addFather(userId, father);

        return new ResponseEntity<>(newFather, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> updateFather(@PathVariable("id") Integer id, @RequestBody Father father) {
        fatherService.updateFather(id, father);

        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
