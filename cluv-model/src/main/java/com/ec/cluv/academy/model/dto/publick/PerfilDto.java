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
import java.util.List;

/**
 *
 * @author PC
 */

@Data
@AllArgsConstructor
public class PerfilDto implements Serializable {


    private Integer idPerfil;

    private String nombre;

    private String descripcion;

    private String activo;
    private List<AutorizacionDto> autorizacionListDto;
    private List<PerfilUsuarioDto> perfilUsuarioListDto;

    public PerfilDto() {
    }


}
