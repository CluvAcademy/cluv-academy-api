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
@Table(name = "info_destrezas", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "InfoDestrezas.findAll", query = "SELECT i FROM InfoDestrezas i"),
    @NamedQuery(name = "InfoDestrezas.findByIdInfoDestrezasTutor", query = "SELECT i FROM InfoDestrezas i WHERE i.idInfoDestrezasTutor = :idInfoDestrezasTutor"),
    @NamedQuery(name = "InfoDestrezas.findByNombreInfoDestrezasTutor", query = "SELECT i FROM InfoDestrezas i WHERE i.nombreInfoDestrezasTutor = :nombreInfoDestrezasTutor"),
    @NamedQuery(name = "InfoDestrezas.findByActivoInfoDestrezasTutor", query = "SELECT i FROM InfoDestrezas i WHERE i.activoInfoDestrezasTutor = :activoInfoDestrezasTutor")})
public class InfoDestrezas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_info_destrezas_tutor")
    private Long idInfoDestrezasTutor;
    @Column(name = "nombre_info_destrezas_tutor")
    private String nombreInfoDestrezasTutor;
    @Column(name = "activo_info_destrezas_tutor")
    private Boolean activoInfoDestrezasTutor;
    @JoinColumn(name = "id_tutor", referencedColumnName = "id_tutor")
    @ManyToOne
    private Tutor idTutor;

    public InfoDestrezas() {
    }


}
