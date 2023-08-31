/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.entities.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author PC
 */
@Data
@AllArgsConstructor
@Entity
@Table(name = "postulaciones", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "Postulaciones.findAll", query = "SELECT p FROM Postulaciones p"),
    @NamedQuery(name = "Postulaciones.findByIdPostulacion", query = "SELECT p FROM Postulaciones p WHERE p.idPostulacion = :idPostulacion"),
    @NamedQuery(name = "Postulaciones.findByNombrePostulacion", query = "SELECT p FROM Postulaciones p WHERE p.nombrePostulacion = :nombrePostulacion"),
    @NamedQuery(name = "Postulaciones.findByDescripcionPostulacion", query = "SELECT p FROM Postulaciones p WHERE p.descripcionPostulacion = :descripcionPostulacion"),
    @NamedQuery(name = "Postulaciones.findByFechaInicioPostulacion", query = "SELECT p FROM Postulaciones p WHERE p.fechaInicioPostulacion = :fechaInicioPostulacion"),
    @NamedQuery(name = "Postulaciones.findByFechaFinPostulacion", query = "SELECT p FROM Postulaciones p WHERE p.fechaFinPostulacion = :fechaFinPostulacion"),
    @NamedQuery(name = "Postulaciones.findByRecursosPostulacion", query = "SELECT p FROM Postulaciones p WHERE p.recursosPostulacion = :recursosPostulacion"),
    @NamedQuery(name = "Postulaciones.findByIdClubPostulacion", query = "SELECT p FROM Postulaciones p WHERE p.idClubPostulacion = :idClubPostulacion"),
    @NamedQuery(name = "Postulaciones.findByIdMateriaPostulacion", query = "SELECT p FROM Postulaciones p WHERE p.idMateriaPostulacion = :idMateriaPostulacion"),
    @NamedQuery(name = "Postulaciones.findByIdPaquetePostulacion", query = "SELECT p FROM Postulaciones p WHERE p.idPaquetePostulacion = :idPaquetePostulacion"),
    @NamedQuery(name = "Postulaciones.findByActivoPostulacion", query = "SELECT p FROM Postulaciones p WHERE p.activoPostulacion = :activoPostulacion")})
public class Postulaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_postulacion")
    private Long idPostulacion;
    @Column(name = "nombre_postulacion")
    private String nombrePostulacion;
    @Column(name = "descripcion_postulacion")
    private String descripcionPostulacion;
    @Column(name = "fecha_inicio_postulacion")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioPostulacion;
    @Column(name = "fecha_fin_postulacion")
    @Temporal(TemporalType.DATE)
    private Date fechaFinPostulacion;
    @Column(name = "recursos_postulacion")
    private String recursosPostulacion;
    @Column(name = "id_club_postulacion")
    private BigInteger idClubPostulacion;
    @Column(name = "id_materia_postulacion")
    private BigInteger idMateriaPostulacion;
    @Column(name = "id_paquete_postulacion")
    private BigInteger idPaquetePostulacion;
    @Column(name = "activo_postulacion")
    private Boolean activoPostulacion;
    @JoinColumn(name = "id_estado_postulacion", referencedColumnName = "id_estado_postulacion")
    @ManyToOne
    private EstadoPostulacion idEstadoPostulacion;
    @JoinColumn(name = "id_tutor", referencedColumnName = "id_tutor")
    @ManyToOne
    private Tutor idTutor;

    public Postulaciones() {
    }


    
}
