/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.dto.academy;

import com.ec.cluv.academy.model.entities.academy.Club;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author PC
 */
@Data
@AllArgsConstructor
public class ForoClubDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idForoClub;
    private String descripcionForoClub;
    private BigInteger foroPadreForoClub;
    private Boolean activoForoClub;
    private ClubDto idClubDto;

    public ForoClubDto() {
    }

}
