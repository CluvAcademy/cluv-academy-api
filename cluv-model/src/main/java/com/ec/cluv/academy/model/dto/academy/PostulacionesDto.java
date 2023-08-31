/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.dto.academy;

import com.ec.cluv.academy.model.entities.academy.EstadoPostulacion;
import com.ec.cluv.academy.model.entities.academy.Tutor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
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
public class PostulacionesDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idPostulacion;
    private String nombrePostulacion;
    private String descripcionPostulacion;
    private Date fechaInicioPostulacion;
    private Date fechaFinPostulacion;
    private String recursosPostulacion;
    private BigInteger idClubPostulacion;
    private BigInteger idMateriaPostulacion;
    private BigInteger idPaquetePostulacion;
    private Boolean activoPostulacion;
    private EstadoPostulacionDto idEstadoPostulacionDto;
    private TutorDto idTutorDto;

    public PostulacionesDto() {
    }


}
