/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.ProyectoIntegrador.controller;

import com.upeu.ProyectoIntegrador.entity.TipoPersona;
import com.upeu.ProyectoIntegrador.service.TipoPersonaService;
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
@RequestMapping("/tipo-persona")
public class TipoPersonaController {
    
    @Autowired
    private TipoPersonaService tipoPersonaService;

    @GetMapping("/all")
    public List<TipoPersona> findAll() {
        return tipoPersonaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPersona> findById(@PathVariable Long id) {
        TipoPersona tipoPersona = tipoPersonaService.findById(id);
        return ResponseEntity.ok(tipoPersona);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        tipoPersonaService.deleteById(id);
    }

    @PostMapping("/save")
    public TipoPersona save(@RequestBody TipoPersona tipoPersona) {
        return tipoPersonaService.save(tipoPersona);
    }

    @PutMapping("/update")
    public TipoPersona update(@RequestBody TipoPersona tipoPersona) {
        return tipoPersonaService.save(tipoPersona);
    }
}
