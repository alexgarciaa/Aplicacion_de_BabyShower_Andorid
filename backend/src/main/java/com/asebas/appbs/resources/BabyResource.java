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

import com.asebas.appbs.domain.Baby;
import com.asebas.appbs.services.BabyService;

@RestController
@RequestMapping("/api/baby")
public class BabyResource {

    @Autowired
    private BabyService babyService;

    @GetMapping("/{id}")
    public ResponseEntity<Baby> getBabyById(@PathVariable("id") Integer id) {
        Baby baby = babyService.getBabyById(id);

        return new ResponseEntity<>(baby, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Baby> addBaby(@RequestBody Map<String, Object> babyMap) {
        String primerNombre = (String) babyMap.get("primerNombre");
        String segundoNombre = (String) babyMap.get("segundoNombre");
        String primerApellido = (String) babyMap.get("primerApellido");
        String segundoApellido = (String) babyMap.get("segundoApellido");
        String fechaEstNac = (String) babyMap.get("fechaEstNac");
        String sexo = (String) babyMap.get("sexo");
        String padreEmail = (String) babyMap.get("padreEmail");
        String madreEmail = (String) babyMap.get("madreEmail");

        Baby baby = babyService.addBaby(primerNombre, segundoNombre, primerApellido, segundoApellido, fechaEstNac, sexo,
                padreEmail, madreEmail);

        return new ResponseEntity<>(baby, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> updateBaby(@PathVariable("id") Integer id, @RequestBody Baby baby) {
        babyService.updateBaby(id, baby);

        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
