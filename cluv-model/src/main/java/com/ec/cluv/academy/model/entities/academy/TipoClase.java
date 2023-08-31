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
@Table(name = "tipo_clase", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "TipoClase.findAll", query = "SELECT t FROM TipoClase t"),
    @NamedQuery(name = "TipoClase.findByIdTipoClase", query = "SELECT t FROM TipoClase t WHERE t.idTipoClase = :idTipoClase"),
    @NamedQuery(name = "TipoClase.findByNombreTipoClase", query = "SELECT t FROM TipoClase t WHERE t.nombreTipoClase = :nombreTipoClase"),
    @NamedQuery(name = "TipoClase.findByDescripcionTipoClase", query = "SELECT t FROM TipoClase t WHERE t.descripcionTipoClase = :descripcionTipoClase"),
    @NamedQuery(name = "TipoClase.findByActivoTipoClase", query = "SELECT t FROM TipoClase t WHERE t.activoTipoClase = :activoTipoClase")})
public class TipoClase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_clase")
    private Long idTipoClase;
    @Column(name = "nombre_tipo_clase")
    private String nombreTipoClase;
    @Column(name = "descripcion_tipo_clase")
    private String descripcionTipoClase;
    @Column(name = "activo_tipo_clase")
    private Boolean activoTipoClase;
    @OneToMany(mappedBy = "idTipoClase")
    private Collection<Clase> claseCollection;

    public TipoClase() {
    }


}
