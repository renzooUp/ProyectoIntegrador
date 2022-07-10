/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.ProyectoIntegrador.controller;

import com.upeu.ProyectoIntegrador.entity.TipoDocumento;
import com.upeu.ProyectoIntegrador.service.TipoDocumentoService;
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
@RequestMapping("/tipoDocumento")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping("/all")
    public List<TipoDocumento> findAll() {
        return tipoDocumentoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDocumento> findById(@PathVariable Long id) {
        TipoDocumento tipoDocumento = tipoDocumentoService.findById(id);
        return ResponseEntity.ok(tipoDocumento);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        tipoDocumentoService.deleteById(id);
    }

    @PostMapping("/save")
    public TipoDocumento save(@RequestBody TipoDocumento tipoDocumento) {
        return tipoDocumentoService.save(tipoDocumento);
    }

    @PutMapping("/update")
    public TipoDocumento update(@RequestBody TipoDocumento tipoDocumento) {
        //TipoDocumento aut = new TipoDocumento(tipoDocumento.getId(),tipoDocumento.getNombres(),tipoDocumento.getApellidos(), tipoDocumento.getEstado());        
        return tipoDocumentoService.save(tipoDocumento);
    }
}
