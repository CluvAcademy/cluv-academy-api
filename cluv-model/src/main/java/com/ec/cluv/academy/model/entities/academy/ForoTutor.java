/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.entities.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

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
@Table(name = "foro_tutor", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "ForoTutor.findAll", query = "SELECT f FROM ForoTutor f"),
    @NamedQuery(name = "ForoTutor.findByIdForoTutor", query = "SELECT f FROM ForoTutor f WHERE f.idForoTutor = :idForoTutor"),
    @NamedQuery(name = "ForoTutor.findByDescripcionForoTutor", query = "SELECT f FROM ForoTutor f WHERE f.descripcionForoTutor = :descripcionForoTutor"),
    @NamedQuery(name = "ForoTutor.findByForoPadreForoTutor", query = "SELECT f FROM ForoTutor f WHERE f.foroPadreForoTutor = :foroPadreForoTutor"),
    @NamedQuery(name = "ForoTutor.findByActivoForoTutor", query = "SELECT f FROM ForoTutor f WHERE f.activoForoTutor = :activoForoTutor")})
public class ForoTutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_foro_tutor")
    private Long idForoTutor;
    @Column(name = "descripcion_foro_tutor")
    private String descripcionForoTutor;
    @Column(name = "foro_padre_foro_tutor")
    private BigInteger foroPadreForoTutor;
    @Column(name = "activo_foro_tutor")
    private Boolean activoForoTutor;
    @JoinColumn(name = "id_tutor", referencedColumnName = "id_tutor")
    @ManyToOne
    private Tutor idTutor;

    public ForoTutor() {
    }


}
