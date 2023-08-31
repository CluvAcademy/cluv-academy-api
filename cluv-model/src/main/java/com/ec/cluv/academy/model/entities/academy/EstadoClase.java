/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.entities.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author PC
 */
@Data
@AllArgsConstructor
@Entity
@Table(name = "estado_clase", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "EstadoClase.findAll", query = "SELECT e FROM EstadoClase e"),
    @NamedQuery(name = "EstadoClase.findByIdEstadoClase", query = "SELECT e FROM EstadoClase e WHERE e.idEstadoClase = :idEstadoClase"),
    @NamedQuery(name = "EstadoClase.findByNombreEstadoClase", query = "SELECT e FROM EstadoClase e WHERE e.nombreEstadoClase = :nombreEstadoClase"),
    @NamedQuery(name = "EstadoClase.findByDescripcionEstadoClase", query = "SELECT e FROM EstadoClase e WHERE e.descripcionEstadoClase = :descripcionEstadoClase"),
    @NamedQuery(name = "EstadoClase.findByActivoEstadoClase", query = "SELECT e FROM EstadoClase e WHERE e.activoEstadoClase = :activoEstadoClase")})
public class EstadoClase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_clase")
    private Long idEstadoClase;
    @Column(name = "nombre_estado_clase")
    private String nombreEstadoClase;
    @Column(name = "descripcion_estado_clase")
    private String descripcionEstadoClase;
    @Column(name = "activo_estado_clase")
    private Boolean activoEstadoClase;
    @OneToMany(mappedBy = "idEstadoClase")
    private Collection<Clase> claseCollection;

    public EstadoClase() {
    }


    
}
