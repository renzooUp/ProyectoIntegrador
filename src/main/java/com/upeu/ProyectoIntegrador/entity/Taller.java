/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.ProyectoIntegrador.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "taller")
public class Taller implements Serializable{

    @Id
    @Column(name = "tall_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tallId;

    @Column(name = "tall_tema")
    private String tallTema;

    @Column(name = "tall_fecha")
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date tallFecha;

    @Column(name = "tall_hora")
    private String tallHora;

    @Column(name = "tall_lugar")
    private String tallLugar;

    @Column(name = "tall_direccion")
    private String tallDireccion;

    @ManyToOne
    @JoinColumn(name = "prog_id")
    private Programa programa;
}
