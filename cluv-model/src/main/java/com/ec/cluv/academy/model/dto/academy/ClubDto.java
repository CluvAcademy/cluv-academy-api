/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.dto.academy;

import com.ec.cluv.academy.model.entities.academy.CalificacionClub;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author PC
 */
@Data
@AllArgsConstructor
public class ClubDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idClub;
    private String nombreClub;
    private String descripcionClub;
    private String objetivosClub;
    private String introduccionClub;
    private String avatarClub;
    private Boolean activoClub;
    private Collection<ForoClubDto> foroClubCollectionDto;
    private ReconocimientoClubDto idReconocimientoClubDto;
    private Collection<MateriaDto> materiaCollectionDto;
    private Collection<CalificacionClubDto> calificacionClubCollectionDto;


    public ClubDto() {
    }

}
