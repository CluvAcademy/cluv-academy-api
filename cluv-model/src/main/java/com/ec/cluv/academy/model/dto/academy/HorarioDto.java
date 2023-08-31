/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.dto.academy;

import com.ec.cluv.academy.model.entities.academy.*;
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
 * @author PC
 */
@Data
@AllArgsConstructor
public class HorarioDto implements Serializable {

    private static final long serialVersionUID = 1L;

    protected HorarioPKDto horarioPKDto;
    private Integer cantClubsHorario;
    private Integer cantEstudiantesHorario;
    private Integer cantTutoresHorario;
    private Short activoHorario;
    private DiasHorarioDto diasHorarioDto;
    private EstadoHorarioDto idEstadoHorarioDto;
    private HorasHorarioDto horasHorarioDto;
    private Collection<ClaseDto> claseCollectionDto;

    public HorarioDto() {
    }

}
