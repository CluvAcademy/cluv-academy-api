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
@Table(name = "tipo_paquete", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "TipoPaquete.findAll", query = "SELECT t FROM TipoPaquete t"),
    @NamedQuery(name = "TipoPaquete.findByIdTipoPaquete", query = "SELECT t FROM TipoPaquete t WHERE t.idTipoPaquete = :idTipoPaquete"),
    @NamedQuery(name = "TipoPaquete.findByNombreTipoPaquete", query = "SELECT t FROM TipoPaquete t WHERE t.nombreTipoPaquete = :nombreTipoPaquete"),
    @NamedQuery(name = "TipoPaquete.findByDescripcionTipoPaquete", query = "SELECT t FROM TipoPaquete t WHERE t.descripcionTipoPaquete = :descripcionTipoPaquete"),
    @NamedQuery(name = "TipoPaquete.findByActivoTipoPaquete", query = "SELECT t FROM TipoPaquete t WHERE t.activoTipoPaquete = :activoTipoPaquete")})
public class TipoPaquete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_paquete")
    private Long idTipoPaquete;
    @Column(name = "nombre_tipo_paquete")
    private String nombreTipoPaquete;
    @Column(name = "descripcion_tipo_paquete")
    private String descripcionTipoPaquete;
    @Column(name = "activo_tipo_paquete")
    private Boolean activoTipoPaquete;
    @OneToMany(mappedBy = "idTipoPaquete")
    private Collection<Paquete> paqueteCollection;

    public TipoPaquete() {
    }


}
