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
@Table(name = "estado_actividad_tutor", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "EstadoActividadTutor.findAll", query = "SELECT e FROM EstadoActividadTutor e"),
    @NamedQuery(name = "EstadoActividadTutor.findByIdEstadoActividadTutor", query = "SELECT e FROM EstadoActividadTutor e WHERE e.idEstadoActividadTutor = :idEstadoActividadTutor"),
    @NamedQuery(name = "EstadoActividadTutor.findByNombreEstadoActividadTutor", query = "SELECT e FROM EstadoActividadTutor e WHERE e.nombreEstadoActividadTutor = :nombreEstadoActividadTutor"),
    @NamedQuery(name = "EstadoActividadTutor.findByDescripcio", query = "SELECT e FROM EstadoActividadTutor e WHERE e.descripcio = :descripcio"),
    @NamedQuery(name = "EstadoActividadTutor.findByActivoEstadoActividadTutor", query = "SELECT e FROM EstadoActividadTutor e WHERE e.activoEstadoActividadTutor = :activoEstadoActividadTutor")})
public class EstadoActividadTutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_actividad_tutor")
    private Long idEstadoActividadTutor;
    @Column(name = "nombre_estado_actividad_tutor")
    private String nombreEstadoActividadTutor;
    @Column(name = "descripcio")
    private String descripcio;
    @Column(name = "activo_estado_actividad_tutor")
    private Boolean activoEstadoActividadTutor;
    @OneToMany(mappedBy = "idEstadoActividadTutor")
    private Collection<Tutor> tutorCollection;

    public EstadoActividadTutor() {
    }


    
}
