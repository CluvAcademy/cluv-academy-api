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

/**
 *
 * @author PC
 */
@Data
@AllArgsConstructor
public class AutorizacionDto implements Serializable {


    private Integer idAutorizacion;

    private String permisos;

    private MenuDto idMenuDto;

    private PerfilDto idPerfilDto;

    public AutorizacionDto() {
    }


}
