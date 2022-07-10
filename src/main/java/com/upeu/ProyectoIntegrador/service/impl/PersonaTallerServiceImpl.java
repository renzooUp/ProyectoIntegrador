/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.ProyectoIntegrador.service.impl;

import com.upeu.ProyectoIntegrador.entity.PersonaTaller;
import com.upeu.ProyectoIntegrador.entity.Taller;
import com.upeu.ProyectoIntegrador.repository.PersonaTallerRepository;
import com.upeu.ProyectoIntegrador.service.PersonaTallerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaTallerServiceImpl implements PersonaTallerService{
 
    @Autowired
    private PersonaTallerRepository personaTallerRepository;

    @Transactional(readOnly = true)
    @Override
    public List<PersonaTaller> findAll() {
        return (List<PersonaTaller>) personaTallerRepository.findAll();
    }

    @Override
    public PersonaTaller findById(Long id) {
        return personaTallerRepository.findById(id).orElse(null);
    }

    @Override
    public List<PersonaTaller> findByTaller(Taller taller) {
        return (List<PersonaTaller>) personaTallerRepository.findByTaller(taller);
    }

    @Override
    public PersonaTaller save(PersonaTaller personaTaller) {
        return personaTallerRepository.save(personaTaller);
    }

    @Override
    public void delete(PersonaTaller personaTaller) {
        personaTallerRepository.delete(personaTaller);
    }

    @Override
    public void deleteById(Long id) {
        personaTallerRepository.deleteById(id);
    }
}
