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
@Table(name = "carrito_compras", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "CarritoCompras.findAll", query = "SELECT c FROM CarritoCompras c"),
    @NamedQuery(name = "CarritoCompras.findByIdCarritoCompras", query = "SELECT c FROM CarritoCompras c WHERE c.idCarritoCompras = :idCarritoCompras"),
    @NamedQuery(name = "CarritoCompras.findByValorCarritoCompras", query = "SELECT c FROM CarritoCompras c WHERE c.valorCarritoCompras = :valorCarritoCompras"),
    @NamedQuery(name = "CarritoCompras.findByCantidadCarritoCompras", query = "SELECT c FROM CarritoCompras c WHERE c.cantidadCarritoCompras = :cantidadCarritoCompras"),
    @NamedQuery(name = "CarritoCompras.findByRecargoCarritoCompras", query = "SELECT c FROM CarritoCompras c WHERE c.recargoCarritoCompras = :recargoCarritoCompras"),
    @NamedQuery(name = "CarritoCompras.findByDescuentoCarritoCompras", query = "SELECT c FROM CarritoCompras c WHERE c.descuentoCarritoCompras = :descuentoCarritoCompras"),
    @NamedQuery(name = "CarritoCompras.findByActivoCarritoCompras", query = "SELECT c FROM CarritoCompras c WHERE c.activoCarritoCompras = :activoCarritoCompras")})
public class CarritoCompras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_carrito_compras")
    private Long idCarritoCompras;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_carrito_compras")
    private Double valorCarritoCompras;
    @Column(name = "cantidad_carrito_compras")
    private BigInteger cantidadCarritoCompras;
    @Column(name = "recargo_carrito_compras")
    private Double recargoCarritoCompras;
    @Column(name = "descuento_carrito_compras")
    private Double descuentoCarritoCompras;
    @Column(name = "activo_carrito_compras")
    private Boolean activoCarritoCompras;
    @JoinColumn(name = "id_clase", referencedColumnName = "id_clase")
    @ManyToOne
    private Clase idClase;
    @JoinColumn(name = "id_estado_carrito_compras", referencedColumnName = "id_estado_carrito_compras")
    @ManyToOne
    private EstadoCarritoCompras idEstadoCarritoCompras;
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante")
    @ManyToOne
    private Estudiante idEstudiante;
    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura")
    @ManyToOne
    private Factura idFactura;

    public CarritoCompras() {
    }


    
}
