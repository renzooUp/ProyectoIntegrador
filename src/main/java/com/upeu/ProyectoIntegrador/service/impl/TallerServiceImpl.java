/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.ProyectoIntegrador.service.impl;

import com.upeu.ProyectoIntegrador.entity.Taller;
import com.upeu.ProyectoIntegrador.repository.TallerRepository;
import com.upeu.ProyectoIntegrador.service.TallerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TallerServiceImpl implements TallerService{
 
    @Autowired
    private TallerRepository tallerRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Taller> findAll() {
        return (List<Taller>) tallerRepository.findAll();
    }

    @Override
    public Taller findById(Long id) {
        return tallerRepository.findById(id).orElse(null);
    }

    @Override
    public Taller save(Taller taller) {
        return tallerRepository.save(taller);
    }

    @Override
    public void delete(Taller taller) {
        tallerRepository.delete(taller);
    }

    @Override
    public void deleteById(Long id) {
        tallerRepository.deleteById(id);
    }
}
