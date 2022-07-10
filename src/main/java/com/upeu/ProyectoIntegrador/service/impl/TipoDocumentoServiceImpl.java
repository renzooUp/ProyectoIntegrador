/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.ProyectoIntegrador.service.impl;

import com.upeu.ProyectoIntegrador.entity.TipoDocumento;
import com.upeu.ProyectoIntegrador.repository.TipoDocumentoRepository;
import com.upeu.ProyectoIntegrador.service.TipoDocumentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService{
    
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<TipoDocumento> findAll() {
        return (List<TipoDocumento>) tipoDocumentoRepository.findAll();
    }

    @Override
    public TipoDocumento findById(Long id) {
        return tipoDocumentoRepository.findById(id).orElse(null);
    }

    @Override
    public TipoDocumento save(TipoDocumento tipoDocumento) {
        return tipoDocumentoRepository.save(tipoDocumento);
    }

    @Override
    public void delete(TipoDocumento tipoDocumento) {
        tipoDocumentoRepository.delete(tipoDocumento);
    }

    @Override
    public void deleteById(Long id) {
        tipoDocumentoRepository.deleteById(id);
    }
}
