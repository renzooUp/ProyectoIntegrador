/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.ProyectoIntegrador.controller;

import com.upeu.ProyectoIntegrador.entity.Taller;
import com.upeu.ProyectoIntegrador.service.TallerService;
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
@RequestMapping("/taller")
public class TallerController {
   
    @Autowired
    private TallerService tallerService;

    @GetMapping("/all")
    public List<Taller> findAll() {
        return tallerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taller> findById(@PathVariable Long id) {
        Taller taller = tallerService.findById(id);
        return ResponseEntity.ok(taller);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        tallerService.deleteById(id);
    }

    @PostMapping("/save")
    public Taller save(@RequestBody Taller taller) {
        return tallerService.save(taller);
    }

    @PutMapping("/update")
    public Taller update(@RequestBody Taller taller) {
        return tallerService.save(taller);
    }
}
