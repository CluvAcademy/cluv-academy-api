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
@Table(name = "info_academica_tutor", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "InfoAcademicaTutor.findAll", query = "SELECT i FROM InfoAcademicaTutor i"),
    @NamedQuery(name = "InfoAcademicaTutor.findByIdInfoAcademicaTutor", query = "SELECT i FROM InfoAcademicaTutor i WHERE i.idInfoAcademicaTutor = :idInfoAcademicaTutor"),
    @NamedQuery(name = "InfoAcademicaTutor.findByInstitucion", query = "SELECT i FROM InfoAcademicaTutor i WHERE i.institucion = :institucion"),
    @NamedQuery(name = "InfoAcademicaTutor.findByNivelInfoAcademicaTutor", query = "SELECT i FROM InfoAcademicaTutor i WHERE i.nivelInfoAcademicaTutor = :nivelInfoAcademicaTutor"),
    @NamedQuery(name = "InfoAcademicaTutor.findByTituloInfoAcademicaTutor", query = "SELECT i FROM InfoAcademicaTutor i WHERE i.tituloInfoAcademicaTutor = :tituloInfoAcademicaTutor"),
    @NamedQuery(name = "InfoAcademicaTutor.findByActivoInfoAcademicaTutor", query = "SELECT i FROM InfoAcademicaTutor i WHERE i.activoInfoAcademicaTutor = :activoInfoAcademicaTutor")})
public class InfoAcademicaTutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_info_academica_tutor")
    private Long idInfoAcademicaTutor;
    @Column(name = "institucion")
    private String institucion;
    @Column(name = "nivel_info_academica_tutor")
    private String nivelInfoAcademicaTutor;
    @Column(name = "titulo_info_academica_tutor")
    private String tituloInfoAcademicaTutor;
    @Column(name = "activo_info_academica_tutor")
    private Boolean activoInfoAcademicaTutor;
    @JoinColumn(name = "id_tutor", referencedColumnName = "id_tutor")
    @ManyToOne
    private Tutor idTutor;

    public InfoAcademicaTutor() {
    }


}
