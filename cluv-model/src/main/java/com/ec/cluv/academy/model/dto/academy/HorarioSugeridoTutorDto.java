/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.dto.academy;

import com.ec.cluv.academy.model.entities.academy.Tutor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author PC
 */
@Data
@AllArgsConstructor
public class HorarioSugeridoTutorDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idHorarioSugeridoTutor;
    private Date inicioHorarioSugeridoTutor;
    private Date finHorarioSugeridoTutor;
    private Boolean lunesHorarioSugeridoTutor;
    private Boolean martesHorarioSugeridoTutor;
    private Boolean miercoles;
    private Boolean juevesHorarioSugeridoTutor;
    private Boolean viernesHorarioSugeridoTutor;
    private Boolean sabadoHorarioSugeridoTutor;
    private Boolean domingoHorarioSugeridoTutor;
    private Boolean activoHorarioSugeridoTutor;
    private TutorDto idTutorDto;

    public HorarioSugeridoTutorDto() {
    }

}
