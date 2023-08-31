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
@Table(name = "estado_estudiante", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "EstadoEstudiante.findAll", query = "SELECT e FROM EstadoEstudiante e"),
    @NamedQuery(name = "EstadoEstudiante.findByIdEstadoEstudiante", query = "SELECT e FROM EstadoEstudiante e WHERE e.idEstadoEstudiante = :idEstadoEstudiante"),
    @NamedQuery(name = "EstadoEstudiante.findByNombreEstadoEstudiante", query = "SELECT e FROM EstadoEstudiante e WHERE e.nombreEstadoEstudiante = :nombreEstadoEstudiante"),
    @NamedQuery(name = "EstadoEstudiante.findByDescripcionEstadoEstudiante", query = "SELECT e FROM EstadoEstudiante e WHERE e.descripcionEstadoEstudiante = :descripcionEstadoEstudiante"),
    @NamedQuery(name = "EstadoEstudiante.findByActivoEstadoEstudiante", query = "SELECT e FROM EstadoEstudiante e WHERE e.activoEstadoEstudiante = :activoEstadoEstudiante")})
public class EstadoEstudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_estudiante")
    private Long idEstadoEstudiante;
    @Column(name = "nombre_estado_estudiante")
    private String nombreEstadoEstudiante;
    @Column(name = "descripcion_estado_estudiante")
    private String descripcionEstadoEstudiante;
    @Column(name = "activo_estado_estudiante")
    private Boolean activoEstadoEstudiante;
    @OneToMany(mappedBy = "idEstadoEstudiante")
    private Collection<Estudiante> estudianteCollection;

    public EstadoEstudiante() {
    }


}
