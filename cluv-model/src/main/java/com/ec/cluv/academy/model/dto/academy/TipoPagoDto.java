/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.dto.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author PC
 */
@Data
@AllArgsConstructor
public class TipoPagoDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idTipoPago;
    private String nombreTipoPago;
    private String descripcionTipoPago;
    private Boolean activoTipoPago;
    private Collection<PagosDto> pagosCollectionDto;

    public TipoPagoDto() {
    }

}
