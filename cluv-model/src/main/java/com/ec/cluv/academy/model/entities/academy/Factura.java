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
@Table(name = "factura", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura"),
    @NamedQuery(name = "Factura.findByDniFactura", query = "SELECT f FROM Factura f WHERE f.dniFactura = :dniFactura"),
    @NamedQuery(name = "Factura.findByDireccionFactura", query = "SELECT f FROM Factura f WHERE f.direccionFactura = :direccionFactura"),
    @NamedQuery(name = "Factura.findByNombreFactura", query = "SELECT f FROM Factura f WHERE f.nombreFactura = :nombreFactura"),
    @NamedQuery(name = "Factura.findByTelefonoFactura", query = "SELECT f FROM Factura f WHERE f.telefonoFactura = :telefonoFactura"),
    @NamedQuery(name = "Factura.findBySubtotalFactura", query = "SELECT f FROM Factura f WHERE f.subtotalFactura = :subtotalFactura"),
    @NamedQuery(name = "Factura.findByIvaFactura", query = "SELECT f FROM Factura f WHERE f.ivaFactura = :ivaFactura"),
    @NamedQuery(name = "Factura.findByDescuentoFactura", query = "SELECT f FROM Factura f WHERE f.descuentoFactura = :descuentoFactura"),
    @NamedQuery(name = "Factura.findByRecargoFactura", query = "SELECT f FROM Factura f WHERE f.recargoFactura = :recargoFactura"),
    @NamedQuery(name = "Factura.findByTotalFactura", query = "SELECT f FROM Factura f WHERE f.totalFactura = :totalFactura"),
    @NamedQuery(name = "Factura.findByActivoFactura", query = "SELECT f FROM Factura f WHERE f.activoFactura = :activoFactura")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_factura")
    private Long idFactura;
    @Column(name = "dni_factura")
    private String dniFactura;
    @Column(name = "direccion_factura")
    private String direccionFactura;
    @Column(name = "nombre_factura")
    private String nombreFactura;
    @Column(name = "telefono_factura")
    private String telefonoFactura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "subtotal_factura")
    private Double subtotalFactura;
    @Column(name = "iva_factura")
    private Double ivaFactura;
    @Column(name = "descuento_factura")
    private Double descuentoFactura;
    @Column(name = "recargo_factura")
    private Double recargoFactura;
    @Column(name = "total_factura")
    private Double totalFactura;
    @Column(name = "activo_factura")
    private Boolean activoFactura;
    @JoinColumn(name = "id_estado_factura", referencedColumnName = "id_estado_factura")
    @ManyToOne
    private EstadoFactura idEstadoFactura;
    @OneToMany(mappedBy = "idFactura")
    private Collection<Pagos> pagosCollection;
    @OneToMany(mappedBy = "idFactura")
    private Collection<CarritoCompras> carritoComprasCollection;

    public Factura() {
    }


}
