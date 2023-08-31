/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.entities.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author PC
 */
@Data
@AllArgsConstructor
@Entity
@Table(name = "paquete", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "Paquete.findAll", query = "SELECT p FROM Paquete p"),
    @NamedQuery(name = "Paquete.findByIdPaquete", query = "SELECT p FROM Paquete p WHERE p.idPaquete = :idPaquete"),
    @NamedQuery(name = "Paquete.findByNombrePaquete", query = "SELECT p FROM Paquete p WHERE p.nombrePaquete = :nombrePaquete"),
    @NamedQuery(name = "Paquete.findByDescripcionPaquete", query = "SELECT p FROM Paquete p WHERE p.descripcionPaquete = :descripcionPaquete"),
    @NamedQuery(name = "Paquete.findByCostoPaquete", query = "SELECT p FROM Paquete p WHERE p.costoPaquete = :costoPaquete"),
    @NamedQuery(name = "Paquete.findByDescuentoPaquete", query = "SELECT p FROM Paquete p WHERE p.descuentoPaquete = :descuentoPaquete"),
    @NamedQuery(name = "Paquete.findByTotalPaquete", query = "SELECT p FROM Paquete p WHERE p.totalPaquete = :totalPaquete"),
    @NamedQuery(name = "Paquete.findByActivoPaquete", query = "SELECT p FROM Paquete p WHERE p.activoPaquete = :activoPaquete")})
public class Paquete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_paquete")
    private Long idPaquete;
    @Column(name = "nombre_paquete")
    private String nombrePaquete;
    @Column(name = "descripcion_paquete")
    private String descripcionPaquete;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo_paquete")
    private Double costoPaquete;
    @Column(name = "descuento_paquete")
    private Double descuentoPaquete;
    @Column(name = "total_paquete")
    private Double totalPaquete;
    @Column(name = "activo_paquete")
    private Boolean activoPaquete;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
    @ManyToOne
    private Materia idMateria;
    @JoinColumn(name = "id_tipo_paquete", referencedColumnName = "id_tipo_paquete")
    @ManyToOne
    private TipoPaquete idTipoPaquete;

    public Paquete() {
    }


}
