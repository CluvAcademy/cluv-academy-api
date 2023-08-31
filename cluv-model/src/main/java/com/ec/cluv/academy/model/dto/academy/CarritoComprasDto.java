/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.dto.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author PC
 */
@Data
@AllArgsConstructor
public class CarritoComprasDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idCarritoCompras;
    private Double valorCarritoCompras;
    private BigInteger cantidadCarritoCompras;
    private Double recargoCarritoCompras;
    private Double descuentoCarritoCompras;
    private Boolean activoCarritoCompras;
    private ClaseDto idClaseDto;
    private EstadoCarritoComprasDto idEstadoCarritoComprasDto;
    private EstudianteDto idEstudianteDto;
    private FacturaDto idFacturaDto;

    public CarritoComprasDto() {
    }

}
