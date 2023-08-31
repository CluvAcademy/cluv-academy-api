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
@Table(name = "estado_horario", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "EstadoHorario.findAll", query = "SELECT e FROM EstadoHorario e"),
    @NamedQuery(name = "EstadoHorario.findByIdEstadoHorario", query = "SELECT e FROM EstadoHorario e WHERE e.idEstadoHorario = :idEstadoHorario"),
    @NamedQuery(name = "EstadoHorario.findByNombreEstadoHorario", query = "SELECT e FROM EstadoHorario e WHERE e.nombreEstadoHorario = :nombreEstadoHorario"),
    @NamedQuery(name = "EstadoHorario.findByDescripcionEstadoHorario", query = "SELECT e FROM EstadoHorario e WHERE e.descripcionEstadoHorario = :descripcionEstadoHorario"),
    @NamedQuery(name = "EstadoHorario.findByActivoEstadoHorario", query = "SELECT e FROM EstadoHorario e WHERE e.activoEstadoHorario = :activoEstadoHorario")})
public class EstadoHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_horario")
    private Long idEstadoHorario;
    @Column(name = "nombre_estado_horario")
    private String nombreEstadoHorario;
    @Column(name = "descripcion_estado_horario")
    private String descripcionEstadoHorario;
    @Column(name = "activo_estado_horario")
    private Boolean activoEstadoHorario;
    @OneToMany(mappedBy = "idEstadoHorario")
    private Collection<Horario> horarioCollection;

    public EstadoHorario() {
    }


}
