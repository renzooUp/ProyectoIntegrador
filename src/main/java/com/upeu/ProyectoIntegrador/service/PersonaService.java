/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.upeu.ProyectoIntegrador.service;

import com.upeu.ProyectoIntegrador.entity.Persona;
import java.util.List;

/**
 *
 * @author Renzo Renato
 */
public interface PersonaService {

    public List<Persona> findAll();

    public Persona findById(Long id);

    public Persona findByPersDni(String persDni);

    public Persona save(Persona persona);

    public void delete(Persona persona);

    public void deleteById(Long id);
}
