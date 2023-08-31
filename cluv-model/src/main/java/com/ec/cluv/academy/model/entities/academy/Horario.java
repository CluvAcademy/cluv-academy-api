/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.entities.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Data
@AllArgsConstructor
@Entity
@Table(name = "horario", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h"),
    @NamedQuery(name = "Horario.findByIdHorasHorario", query = "SELECT h FROM Horario h WHERE h.horarioPK.idHorasHorario = :idHorasHorario"),
    @NamedQuery(name = "Horario.findByIdDiasHorario", query = "SELECT h FROM Horario h WHERE h.horarioPK.idDiasHorario = :idDiasHorario"),
    @NamedQuery(name = "Horario.findByCantClubsHorario", query = "SELECT h FROM Horario h WHERE h.cantClubsHorario = :cantClubsHorario"),
    @NamedQuery(name = "Horario.findByCantEstudiantesHorario", query = "SELECT h FROM Horario h WHERE h.cantEstudiantesHorario = :cantEstudiantesHorario"),
    @NamedQuery(name = "Horario.findByCantTutoresHorario", query = "SELECT h FROM Horario h WHERE h.cantTutoresHorario = :cantTutoresHorario"),
    @NamedQuery(name = "Horario.findByActivoHorario", query = "SELECT h FROM Horario h WHERE h.activoHorario = :activoHorario")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HorarioPK horarioPK;
    @Column(name = "cant_clubs_horario")
    private Integer cantClubsHorario;
    @Column(name = "cant_estudiantes_horario")
    private Integer cantEstudiantesHorario;
    @Column(name = "cant_tutores_horario")
    private Integer cantTutoresHorario;
    @Column(name = "activo_horario")
    private Short activoHorario;
    @JoinColumn(name = "id_dias_horario", referencedColumnName = "id_dias_horario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DiasHorario diasHorario;
    @JoinColumn(name = "id_estado_horario", referencedColumnName = "id_estado_horario")
    @ManyToOne
    private EstadoHorario idEstadoHorario;
    @JoinColumn(name = "id_horas_horario", referencedColumnName = "id_horas_horario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HorasHorario horasHorario;
    @OneToMany(mappedBy = "horario")
    private Collection<Clase> claseCollection;

    public Horario() {
    }


}
