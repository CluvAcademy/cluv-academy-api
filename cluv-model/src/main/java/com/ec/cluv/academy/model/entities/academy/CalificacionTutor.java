/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.entities.academy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;

/**
 *
 * @author PC
 */
@Data
@AllArgsConstructor
@Entity
@Table(name = "calificacion_tutor", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "CalificacionTutor.findAll", query = "SELECT c FROM CalificacionTutor c"),
    @NamedQuery(name = "CalificacionTutor.findByIdCalificacionTutor", query = "SELECT c FROM CalificacionTutor c WHERE c.idCalificacionTutor = :idCalificacionTutor"),
    @NamedQuery(name = "CalificacionTutor.findByIdClaseCalificacionTutor", query = "SELECT c FROM CalificacionTutor c WHERE c.idClaseCalificacionTutor = :idClaseCalificacionTutor"),
    @NamedQuery(name = "CalificacionTutor.findByIdMateriaCalificacionTutor", query = "SELECT c FROM CalificacionTutor c WHERE c.idMateriaCalificacionTutor = :idMateriaCalificacionTutor"),
    @NamedQuery(name = "CalificacionTutor.findByActivoCalificacionTutor", query = "SELECT c FROM CalificacionTutor c WHERE c.activoCalificacionTutor = :activoCalificacionTutor")})
public class CalificacionTutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_calificacion_tutor")
    private Long idCalificacionTutor;
    @Column(name = "id_clase_calificacion_tutor")
    private BigInteger idClaseCalificacionTutor;
    @Column(name = "id_materia_calificacion_tutor")
    private BigInteger idMateriaCalificacionTutor;
    @Column(name = "activo_calificacion_tutor")
    private Boolean activoCalificacionTutor;
    @JoinColumn(name = "id_tutor", referencedColumnName = "id_tutor")
    @ManyToOne
    private Tutor idTutor;

    public CalificacionTutor() {
    }


    
}
