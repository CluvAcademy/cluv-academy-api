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
@Table(name = "estado_carrito_compras", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "EstadoCarritoCompras.findAll", query = "SELECT e FROM EstadoCarritoCompras e"),
    @NamedQuery(name = "EstadoCarritoCompras.findByIdEstadoCarritoCompras", query = "SELECT e FROM EstadoCarritoCompras e WHERE e.idEstadoCarritoCompras = :idEstadoCarritoCompras"),
    @NamedQuery(name = "EstadoCarritoCompras.findByNombreEstadoCarritoCompras", query = "SELECT e FROM EstadoCarritoCompras e WHERE e.nombreEstadoCarritoCompras = :nombreEstadoCarritoCompras"),
    @NamedQuery(name = "EstadoCarritoCompras.findByDescripcio", query = "SELECT e FROM EstadoCarritoCompras e WHERE e.descripcio = :descripcio"),
    @NamedQuery(name = "EstadoCarritoCompras.findByActivoEstadoCarritoCompras", query = "SELECT e FROM EstadoCarritoCompras e WHERE e.activoEstadoCarritoCompras = :activoEstadoCarritoCompras")})
public class EstadoCarritoCompras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_carrito_compras")
    private Long idEstadoCarritoCompras;
    @Column(name = "nombre_estado_carrito_compras")
    private String nombreEstadoCarritoCompras;
    @Column(name = "descripcio")
    private String descripcio;
    @Column(name = "activo_estado_carrito_compras")
    private Boolean activoEstadoCarritoCompras;
    @OneToMany(mappedBy = "idEstadoCarritoCompras")
    private Collection<CarritoCompras> carritoComprasCollection;

    public EstadoCarritoCompras() {
    }


    
}
