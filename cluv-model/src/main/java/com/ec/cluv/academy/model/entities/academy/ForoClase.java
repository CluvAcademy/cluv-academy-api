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
@Table(name = "foro_clase", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "ForoClase.findAll", query = "SELECT f FROM ForoClase f"),
    @NamedQuery(name = "ForoClase.findByIdForoClase", query = "SELECT f FROM ForoClase f WHERE f.idForoClase = :idForoClase"),
    @NamedQuery(name = "ForoClase.findByDescripcionForoClase", query = "SELECT f FROM ForoClase f WHERE f.descripcionForoClase = :descripcionForoClase"),
    @NamedQuery(name = "ForoClase.findByForoPadreForoClase", query = "SELECT f FROM ForoClase f WHERE f.foroPadreForoClase = :foroPadreForoClase"),
    @NamedQuery(name = "ForoClase.findByActivoForoClase", query = "SELECT f FROM ForoClase f WHERE f.activoForoClase = :activoForoClase")})
public class ForoClase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_foro_clase")
    private Long idForoClase;
    @Column(name = "descripcion_foro_clase")
    private String descripcionForoClase;
    @Column(name = "foro_padre_foro_clase")
    private BigInteger foroPadreForoClase;
    @Column(name = "activo_foro_clase")
    private Boolean activoForoClase;
    @JoinColumn(name = "id_clase", referencedColumnName = "id_clase")
    @ManyToOne
    private Clase idClase;

    public ForoClase() {
    }


}
