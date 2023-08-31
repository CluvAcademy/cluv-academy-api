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
@Table(name = "estado_postulacion", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "EstadoPostulacion.findAll", query = "SELECT e FROM EstadoPostulacion e"),
    @NamedQuery(name = "EstadoPostulacion.findByIdEstadoPostulacion", query = "SELECT e FROM EstadoPostulacion e WHERE e.idEstadoPostulacion = :idEstadoPostulacion"),
    @NamedQuery(name = "EstadoPostulacion.findByNombreEstadoPostulacion", query = "SELECT e FROM EstadoPostulacion e WHERE e.nombreEstadoPostulacion = :nombreEstadoPostulacion"),
    @NamedQuery(name = "EstadoPostulacion.findByDescripcionEstadoPostulacion", query = "SELECT e FROM EstadoPostulacion e WHERE e.descripcionEstadoPostulacion = :descripcionEstadoPostulacion"),
    @NamedQuery(name = "EstadoPostulacion.findByActivoEstadoPostulacion", query = "SELECT e FROM EstadoPostulacion e WHERE e.activoEstadoPostulacion = :activoEstadoPostulacion")})
public class EstadoPostulacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_postulacion")
    private Long idEstadoPostulacion;
    @Column(name = "nombre_estado_postulacion")
    private String nombreEstadoPostulacion;
    @Column(name = "descripcion_estado_postulacion")
    private String descripcionEstadoPostulacion;
    @Column(name = "activo_estado_postulacion")
    private Boolean activoEstadoPostulacion;
    @OneToMany(mappedBy = "idEstadoPostulacion")
    private Collection<Postulaciones> postulacionesCollection;

    public EstadoPostulacion() {
    }


}
