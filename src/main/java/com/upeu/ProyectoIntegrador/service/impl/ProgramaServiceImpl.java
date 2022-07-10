/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.ProyectoIntegrador.service.impl;

import com.upeu.ProyectoIntegrador.entity.Programa;
import com.upeu.ProyectoIntegrador.repository.ProgramaRepository;
import com.upeu.ProyectoIntegrador.service.ProgramaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProgramaServiceImpl implements ProgramaService{
 
    @Autowired
    private ProgramaRepository programaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Programa> findAll() {
        return (List<Programa>) programaRepository.findAll();
    }

    @Override
    public Programa findById(Long id) {
        return programaRepository.findById(id).orElse(null);
    }

    @Override
    public Programa save(Programa programa) {
        return programaRepository.save(programa);
    }

    @Override
    public void delete(Programa programa) {
        programaRepository.delete(programa);
    }

    @Override
    public void deleteById(Long id) {
        programaRepository.deleteById(id);
    }
}
