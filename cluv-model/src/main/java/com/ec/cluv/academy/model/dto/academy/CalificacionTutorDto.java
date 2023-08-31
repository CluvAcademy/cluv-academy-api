/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.dto.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author PC
 */
@Data
@AllArgsConstructor
public class CalificacionTutorDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idCalificacionTutor;
    private BigInteger idClaseCalificacionTutor;
    private BigInteger idMateriaCalificacionTutor;
    private Boolean activoCalificacionTutor;
    private TutorDto idTutorDto;

    public CalificacionTutorDto() {
    }

}
