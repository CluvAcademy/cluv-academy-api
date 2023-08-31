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
@Table(name = "reconocimiento_club", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "ReconocimientoClub.findAll", query = "SELECT r FROM ReconocimientoClub r"),
    @NamedQuery(name = "ReconocimientoClub.findByIdReconocimientoClub", query = "SELECT r FROM ReconocimientoClub r WHERE r.idReconocimientoClub = :idReconocimientoClub"),
    @NamedQuery(name = "ReconocimientoClub.findByNombreReconocimientoClub", query = "SELECT r FROM ReconocimientoClub r WHERE r.nombreReconocimientoClub = :nombreReconocimientoClub"),
    @NamedQuery(name = "ReconocimientoClub.findByDescripcionReconocimientoClub", query = "SELECT r FROM ReconocimientoClub r WHERE r.descripcionReconocimientoClub = :descripcionReconocimientoClub"),
    @NamedQuery(name = "ReconocimientoClub.findByActivoReconocimientoClub", query = "SELECT r FROM ReconocimientoClub r WHERE r.activoReconocimientoClub = :activoReconocimientoClub")})
public class ReconocimientoClub implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reconocimiento_club")
    private Long idReconocimientoClub;
    @Column(name = "nombre_reconocimiento_club")
    private String nombreReconocimientoClub;
    @Column(name = "descripcion_reconocimiento_club")
    private String descripcionReconocimientoClub;
    @Column(name = "activo_reconocimiento_club")
    private Boolean activoReconocimientoClub;
    @OneToMany(mappedBy = "idReconocimientoClub")
    private Collection<Club> clubCollection;

    public ReconocimientoClub() {
    }


}
