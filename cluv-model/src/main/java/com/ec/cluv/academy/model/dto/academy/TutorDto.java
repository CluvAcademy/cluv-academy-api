/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.dto.academy;

import com.ec.cluv.academy.model.entities.academy.CalificacionTutor;
import com.ec.cluv.academy.model.entities.academy.Clase;
import com.ec.cluv.academy.model.entities.academy.EstadoActividadTutor;
import com.ec.cluv.academy.model.entities.academy.ForoTutor;
import com.ec.cluv.academy.model.entities.academy.HorarioSugeridoTutor;
import com.ec.cluv.academy.model.entities.academy.InfoAcademicaTutor;
import com.ec.cluv.academy.model.entities.academy.InfoBancaria;
import com.ec.cluv.academy.model.entities.academy.InfoDestrezas;
import com.ec.cluv.academy.model.entities.academy.MultimediaTutor;
import com.ec.cluv.academy.model.entities.academy.Postulaciones;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class TutorDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idTutor;
    private String especializacionTutor;
    private String habilidadesTutor;
    private String sobremiTutor;
    private BigInteger valoracionTutor;
    private BigInteger cantEstudiantesTutor;
    private BigInteger catClasesTutor;
    private String experienciaTutor;
    private String redesTutor;
    private String videoPresentacionTutor;
    private String ensenianzaTutor;
    private String curriculumTutor;
    private String metodologiaTutor;
    private String reseniasTutor;
    private Boolean notificaEstudiantesTutor;
    private Boolean notificaForoTutor;
    private Boolean notificaCalificacionTutor;
    private String whatsappmeTutor;
    private BigInteger idUsuarioTutor;
    private Boolean activoTutor;
    private Collection<ForoTutorDto> foroTutorCollectionDto;
    private Collection<ClaseDto> claseCollectionDto;
    private Collection<MultimediaTutorDto> multimediaTutorCollectionDto;
    private Collection<InfoBancariaDto> infoBancariaCollectionDto;
    private Collection<HorarioSugeridoTutorDto> horarioSugeridoTutorCollectionDto;
    private Collection<InfoAcademicaTutorDto> infoAcademicaTutorCollectionDto;
    private EstadoActividadTutorDto idEstadoActividadTutorDto;
    private Collection<PostulacionesDto> postulacionesCollectionDto;
    private Collection<InfoDestrezasDto> infoDestrezasCollectionDto;
    private Collection<CalificacionTutorDto> calificacionTutorCollectionDto;

    public TutorDto() {
    }


}
