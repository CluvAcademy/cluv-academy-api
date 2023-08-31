/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.entities.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author PC
 */
@Data
@AllArgsConstructor
@Entity
@Table(name = "horario_sugerido_tutor", catalog = "cluvacademy", schema = "academy")
@NamedQueries({
    @NamedQuery(name = "HorarioSugeridoTutor.findAll", query = "SELECT h FROM HorarioSugeridoTutor h"),
    @NamedQuery(name = "HorarioSugeridoTutor.findByIdHorarioSugeridoTutor", query = "SELECT h FROM HorarioSugeridoTutor h WHERE h.idHorarioSugeridoTutor = :idHorarioSugeridoTutor"),
    @NamedQuery(name = "HorarioSugeridoTutor.findByInicioHorarioSugeridoTutor", query = "SELECT h FROM HorarioSugeridoTutor h WHERE h.inicioHorarioSugeridoTutor = :inicioHorarioSugeridoTutor"),
    @NamedQuery(name = "HorarioSugeridoTutor.findByFinHorarioSugeridoTutor", query = "SELECT h FROM HorarioSugeridoTutor h WHERE h.finHorarioSugeridoTutor = :finHorarioSugeridoTutor"),
    @NamedQuery(name = "HorarioSugeridoTutor.findByLunesHorarioSugeridoTutor", query = "SELECT h FROM HorarioSugeridoTutor h WHERE h.lunesHorarioSugeridoTutor = :lunesHorarioSugeridoTutor"),
    @NamedQuery(name = "HorarioSugeridoTutor.findByMartesHorarioSugeridoTutor", query = "SELECT h FROM HorarioSugeridoTutor h WHERE h.martesHorarioSugeridoTutor = :martesHorarioSugeridoTutor"),
    @NamedQuery(name = "HorarioSugeridoTutor.findByMiercoles", query = "SELECT h FROM HorarioSugeridoTutor h WHERE h.miercoles = :miercoles"),
    @NamedQuery(name = "HorarioSugeridoTutor.findByJuevesHorarioSugeridoTutor", query = "SELECT h FROM HorarioSugeridoTutor h WHERE h.juevesHorarioSugeridoTutor = :juevesHorarioSugeridoTutor"),
    @NamedQuery(name = "HorarioSugeridoTutor.findByViernesHorarioSugeridoTutor", query = "SELECT h FROM HorarioSugeridoTutor h WHERE h.viernesHorarioSugeridoTutor = :viernesHorarioSugeridoTutor"),
    @NamedQuery(name = "HorarioSugeridoTutor.findBySabadoHorarioSugeridoTutor", query = "SELECT h FROM HorarioSugeridoTutor h WHERE h.sabadoHorarioSugeridoTutor = :sabadoHorarioSugeridoTutor"),
    @NamedQuery(name = "HorarioSugeridoTutor.findByDomingoHorarioSugeridoTutor", query = "SELECT h FROM HorarioSugeridoTutor h WHERE h.domingoHorarioSugeridoTutor = :domingoHorarioSugeridoTutor"),
    @NamedQuery(name = "HorarioSugeridoTutor.findByActivoHorarioSugeridoTutor", query = "SELECT h FROM HorarioSugeridoTutor h WHERE h.activoHorarioSugeridoTutor = :activoHorarioSugeridoTutor")})
public class HorarioSugeridoTutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_horario_sugerido_tutor")
    private Long idHorarioSugeridoTutor;
    @Column(name = "inicio_horario_sugerido_tutor")
    @Temporal(TemporalType.TIME)
    private Date inicioHorarioSugeridoTutor;
    @Column(name = "fin_horario_sugerido_tutor")
    @Temporal(TemporalType.TIME)
    private Date finHorarioSugeridoTutor;
    @Column(name = "lunes_horario_sugerido_tutor")
    private Boolean lunesHorarioSugeridoTutor;
    @Column(name = "martes_horario_sugerido_tutor")
    private Boolean martesHorarioSugeridoTutor;
    @Column(name = "miercoles_")
    private Boolean miercoles;
    @Column(name = "jueves_horario_sugerido_tutor")
    private Boolean juevesHorarioSugeridoTutor;
    @Column(name = "viernes_horario_sugerido_tutor")
    private Boolean viernesHorarioSugeridoTutor;
    @Column(name = "sabado_horario_sugerido_tutor")
    private Boolean sabadoHorarioSugeridoTutor;
    @Column(name = "domingo_horario_sugerido_tutor")
    private Boolean domingoHorarioSugeridoTutor;
    @Column(name = "activo_horario_sugerido_tutor")
    private Boolean activoHorarioSugeridoTutor;
    @JoinColumn(name = "id_tutor", referencedColumnName = "id_tutor")
    @ManyToOne
    private Tutor idTutor;

    public HorarioSugeridoTutor() {
    }


    
}
