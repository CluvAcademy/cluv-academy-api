/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.entities.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author PC
 */
@Data
@AllArgsConstructor
@Entity
@Table(name = "horas_horario", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "HorasHorario.findAll", query = "SELECT h FROM HorasHorario h"),
    @NamedQuery(name = "HorasHorario.findByIdHorasHorario", query = "SELECT h FROM HorasHorario h WHERE h.idHorasHorario = :idHorasHorario"),
    @NamedQuery(name = "HorasHorario.findByHoraInicioHoraHorario", query = "SELECT h FROM HorasHorario h WHERE h.horaInicioHoraHorario = :horaInicioHoraHorario"),
    @NamedQuery(name = "HorasHorario.findByHoraFinHoraHorario", query = "SELECT h FROM HorasHorario h WHERE h.horaFinHoraHorario = :horaFinHoraHorario"),
    @NamedQuery(name = "HorasHorario.findByActivoHoraHorario", query = "SELECT h FROM HorasHorario h WHERE h.activoHoraHorario = :activoHoraHorario")})
public class HorasHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_horas_horario")
    private Long idHorasHorario;
    @Column(name = "hora_inicio_hora_horario")
    @Temporal(TemporalType.TIME)
    private Date horaInicioHoraHorario;
    @Column(name = "hora_fin_hora_horario")
    @Temporal(TemporalType.TIME)
    private Date horaFinHoraHorario;
    @Column(name = "activo_hora_horario")
    private Boolean activoHoraHorario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horasHorario")
    private Collection<Horario> horarioCollection;

    public HorasHorario() {
    }


}
