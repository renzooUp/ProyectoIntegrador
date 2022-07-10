/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.upeu.ProyectoIntegrador.service;

import com.upeu.ProyectoIntegrador.entity.TipoPersona;
import java.util.List;

public interface TipoPersonaService {
    public List<TipoPersona> findAll();

    public TipoPersona findById(Long id);

    public TipoPersona save(TipoPersona tipoPersona);

    public void delete(TipoPersona tipoPersona);

    public void deleteById(Long id);
}
