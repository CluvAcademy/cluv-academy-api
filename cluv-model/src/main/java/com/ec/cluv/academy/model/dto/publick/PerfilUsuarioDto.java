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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
public class PerfilUsuarioDto implements Serializable {

    private static final long serialVersionUID = 1L;

    protected PerfilUsuarioPKDto perfilUsuarioPKDto;

    private PerfilDto perfilDto;
    private UsuarioDto usuarioDto;

    public PerfilUsuarioDto() {
    }


}
