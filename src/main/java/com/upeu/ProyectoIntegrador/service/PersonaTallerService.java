/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.upeu.ProyectoIntegrador.service;

import com.upeu.ProyectoIntegrador.entity.PersonaTaller;
import com.upeu.ProyectoIntegrador.entity.Taller;
import java.util.List;

public interface PersonaTallerService {

    public List<PersonaTaller> findAll();

    public PersonaTaller findById(Long id);

    public List<PersonaTaller> findByTaller(Taller taller);

    public PersonaTaller save(PersonaTaller personaTaller);

    public void delete(PersonaTaller personaTaller);

    public void deleteById(Long id);
}
