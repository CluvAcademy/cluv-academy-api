/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.entities.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author PC
 */
@Data
@AllArgsConstructor
@Embeddable
public class HorarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_horas_horario")
    private long idHorasHorario;
    @Basic(optional = false)
    @Column(name = "id_dias_horario")
    private long idDiasHorario;

    public HorarioPK() {
    }


}
