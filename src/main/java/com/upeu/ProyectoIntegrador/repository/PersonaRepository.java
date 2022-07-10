/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.upeu.ProyectoIntegrador.repository;

import com.upeu.ProyectoIntegrador.entity.Persona;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>{
    // Query Method JPA
    // List<Persona> findByTipoDocumento(Long tidoId);

    Persona findByPersDni(String persDni);
}
