/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.upeu.ProyectoIntegrador.service;

import com.upeu.ProyectoIntegrador.entity.Taller;
import java.util.List;

public interface TallerService {
    public List<Taller> findAll();

    public Taller findById(Long id);

    public Taller save(Taller taller);

    public void delete(Taller taller);

    public void deleteById(Long id);
}
