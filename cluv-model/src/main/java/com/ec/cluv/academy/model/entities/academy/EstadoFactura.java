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
@Table(name = "estado_factura", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "EstadoFactura.findAll", query = "SELECT e FROM EstadoFactura e"),
    @NamedQuery(name = "EstadoFactura.findByIdEstadoFactura", query = "SELECT e FROM EstadoFactura e WHERE e.idEstadoFactura = :idEstadoFactura"),
    @NamedQuery(name = "EstadoFactura.findByNombreEstadoFactura", query = "SELECT e FROM EstadoFactura e WHERE e.nombreEstadoFactura = :nombreEstadoFactura"),
    @NamedQuery(name = "EstadoFactura.findByDescripcionEstadoFactura", query = "SELECT e FROM EstadoFactura e WHERE e.descripcionEstadoFactura = :descripcionEstadoFactura"),
    @NamedQuery(name = "EstadoFactura.findByActivoEstadoFactura", query = "SELECT e FROM EstadoFactura e WHERE e.activoEstadoFactura = :activoEstadoFactura")})
public class EstadoFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_factura")
    private Long idEstadoFactura;
    @Column(name = "nombre_estado_factura")
    private String nombreEstadoFactura;
    @Column(name = "descripcion_estado_factura")
    private String descripcionEstadoFactura;
    @Column(name = "activo_estado_factura")
    private Boolean activoEstadoFactura;
    @OneToMany(mappedBy = "idEstadoFactura")
    private Collection<Factura> facturaCollection;

    public EstadoFactura() {
    }


}
