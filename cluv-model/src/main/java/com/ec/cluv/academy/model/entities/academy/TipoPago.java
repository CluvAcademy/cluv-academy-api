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
@Table(name = "tipo_pago", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "TipoPago.findAll", query = "SELECT t FROM TipoPago t"),
    @NamedQuery(name = "TipoPago.findByIdTipoPago", query = "SELECT t FROM TipoPago t WHERE t.idTipoPago = :idTipoPago"),
    @NamedQuery(name = "TipoPago.findByNombreTipoPago", query = "SELECT t FROM TipoPago t WHERE t.nombreTipoPago = :nombreTipoPago"),
    @NamedQuery(name = "TipoPago.findByDescripcionTipoPago", query = "SELECT t FROM TipoPago t WHERE t.descripcionTipoPago = :descripcionTipoPago"),
    @NamedQuery(name = "TipoPago.findByActivoTipoPago", query = "SELECT t FROM TipoPago t WHERE t.activoTipoPago = :activoTipoPago")})
public class TipoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_pago")
    private Long idTipoPago;
    @Column(name = "nombre_tipo_pago")
    private String nombreTipoPago;
    @Column(name = "descripcion_tipo_pago")
    private String descripcionTipoPago;
    @Column(name = "activo_tipo_pago")
    private Boolean activoTipoPago;
    @OneToMany(mappedBy = "idTipoPago")
    private Collection<Pagos> pagosCollection;

    public TipoPago() {
    }


}
