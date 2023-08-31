/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.dto.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author PC
 */

@Data
@AllArgsConstructor
public class HorarioPKDto implements Serializable {

    private long idHorasHorario;
    private long idDiasHorario;

    public HorarioPKDto() {
    }


}
