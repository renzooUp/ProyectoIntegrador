/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.ProyectoIntegrador.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tipo_persona")
public class TipoPersona implements Serializable{
 
    @Id
    @Column(name = "tipe_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipeId;

    @Column(name = "tipe_nombre")
    private String tipeNombre;

    @Column(name = "tipe_descripcion")
    private String tipeDescripcion;
}
