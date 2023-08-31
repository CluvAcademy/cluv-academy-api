/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.dto.publick;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PC
 */

@Data
@AllArgsConstructor
public class UsuarioDto implements Serializable {


    private Integer idUsuario;
    private String nombreUsuario;
    private String clave;
    private String cedula;
    private Date fechaCreacion;
    private String activo;
    private String nombres;
    private String pathFirma;
    private String avatar;
    private String direccion;
    private String telefono;
    private String celular;
    private String emailPersonal;
    private String emailInstitucional;
    private String zonaHoraria;
    public UsuarioDto() {
    }


}
