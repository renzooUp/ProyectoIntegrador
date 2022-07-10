/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.upeu.ProyectoIntegrador.service;

import com.upeu.ProyectoIntegrador.entity.TipoDocumento;
import java.util.List;

/**
 *
 * @author Renzo Renato
 */
public interface TipoDocumentoService {
    
    public List<TipoDocumento> findAll();

    public TipoDocumento findById(Long id);

    public TipoDocumento save(TipoDocumento tipoDocumento);

    public void delete(TipoDocumento tipoDocumento);

    public void deleteById(Long id);
}
