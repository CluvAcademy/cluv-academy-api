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
public class MenuDto implements Serializable {

    private Integer idMenu;
    private String nombre;
    private String descripcion;
    private String url;
    private int orden;
    private String activo;
    private String tipo;
    private List<AutorizacionDto> autorizacionListDto;
    private AplicacionDto idAplicacionDto;
    private List<MenuDto> menuListDto;
    private MenuDto idMenuPadreDto;

    public MenuDto() {
    }


}
