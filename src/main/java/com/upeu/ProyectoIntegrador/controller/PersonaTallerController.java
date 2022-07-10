/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.ProyectoIntegrador.controller;

import com.upeu.ProyectoIntegrador.entity.Persona;
import com.upeu.ProyectoIntegrador.entity.PersonaTaller;
import com.upeu.ProyectoIntegrador.entity.Taller;
import com.upeu.ProyectoIntegrador.service.PersonaService;
import com.upeu.ProyectoIntegrador.service.PersonaTallerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona-taller")
public class PersonaTallerController {
   
    @Autowired
    private PersonaTallerService personaTallerService;

    @Autowired
    private PersonaService personaService;

    @GetMapping("/all")
    public List<PersonaTaller> findAll() {
        return personaTallerService.findAll();
    }

    @GetMapping("/taller/{id}")
    public List<PersonaTaller> findByTaller(@PathVariable Long id) {
        Taller taller = new Taller();
        taller.setTallId(id);
        return personaTallerService.findByTaller(taller);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaTaller> findById(@PathVariable Long id) {
        PersonaTaller personaTaller = personaTallerService.findById(id);
        return ResponseEntity.ok(personaTaller);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        personaTallerService.deleteById(id);
    }

    @PostMapping("/save")
    public PersonaTaller save(@RequestBody PersonaTaller personaTaller) {
        Persona persona = personaService.findByPersDni(personaTaller.getPersona().getPersDni());
        if (persona == null) {
            return null;
        } else {
            personaTaller.setPersona(persona);
            return personaTallerService.save(personaTaller);
        }
    }

    @PutMapping("/update")
    public PersonaTaller update(@RequestBody PersonaTaller personaTaller) {
        return personaTallerService.save(personaTaller);
    }
}
