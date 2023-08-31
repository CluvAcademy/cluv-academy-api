/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.dto.academy;

import com.ec.cluv.academy.model.entities.academy.Horario;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author PC
 */
@Data
@AllArgsConstructor
public class HorasHorarioDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idHorasHorario;
    private Date horaInicioHoraHorario;
    private Date horaFinHoraHorario;
    private Boolean activoHoraHorario;
    private Collection<HorarioDto> horarioCollectionDto;

    public HorasHorarioDto() {
    }

}
