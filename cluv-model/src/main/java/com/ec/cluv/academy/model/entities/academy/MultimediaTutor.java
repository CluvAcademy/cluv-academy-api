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
@Table(name = "multimedia_tutor", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "MultimediaTutor.findAll", query = "SELECT m FROM MultimediaTutor m"),
    @NamedQuery(name = "MultimediaTutor.findByIdMultimediaTutor", query = "SELECT m FROM MultimediaTutor m WHERE m.idMultimediaTutor = :idMultimediaTutor"),
    @NamedQuery(name = "MultimediaTutor.findByNombreMultimediaTutor", query = "SELECT m FROM MultimediaTutor m WHERE m.nombreMultimediaTutor = :nombreMultimediaTutor"),
    @NamedQuery(name = "MultimediaTutor.findByPathMultimediaTutor", query = "SELECT m FROM MultimediaTutor m WHERE m.pathMultimediaTutor = :pathMultimediaTutor"),
    @NamedQuery(name = "MultimediaTutor.findByDescripcionMultimediaTutor", query = "SELECT m FROM MultimediaTutor m WHERE m.descripcionMultimediaTutor = :descripcionMultimediaTutor"),
    @NamedQuery(name = "MultimediaTutor.findByActivoMultimediaTutor", query = "SELECT m FROM MultimediaTutor m WHERE m.activoMultimediaTutor = :activoMultimediaTutor")})
public class MultimediaTutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_multimedia_tutor")
    private Long idMultimediaTutor;
    @Column(name = "nombre_multimedia_tutor")
    private String nombreMultimediaTutor;
    @Column(name = "path_multimedia_tutor")
    private String pathMultimediaTutor;
    @Column(name = "descripcion_multimedia_tutor")
    private String descripcionMultimediaTutor;
    @Column(name = "activo_multimedia_tutor")
    private Boolean activoMultimediaTutor;
    @JoinColumn(name = "id_tutor", referencedColumnName = "id_tutor")
    @ManyToOne
    private Tutor idTutor;

    public MultimediaTutor() {
    }


}
