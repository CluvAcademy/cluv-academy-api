/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.dto.academy;

import com.ec.cluv.academy.model.entities.academy.Clase;
import com.ec.cluv.academy.model.entities.academy.Club;
import com.ec.cluv.academy.model.entities.academy.Paquete;
import com.ec.cluv.academy.model.entities.academy.Silabo;
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
public class MateriaDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idMateria;
    private String nombreMateria;
    private String descripcionMateria;
    private BigInteger valoracionMateria;
    private String recursosMateria;
    private String materialesMateria;
    private BigInteger aforoReferencialMateria;
    private Double costoReferencialMateria;
    private Boolean activoMateria;
    private Collection<PaqueteDto> paqueteCollectionDto;
    private Collection<ClaseDto> claseCollectionDto;
    private Collection<SilaboDto> silaboCollectionDto;
    private ClubDto idClubDto;

    public MateriaDto() {
    }


}
