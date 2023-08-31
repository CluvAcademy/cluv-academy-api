/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ec.cluv.academy.model.dto.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

/**
 * @author PC
 */
@Data
@AllArgsConstructor
public class ClaseDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idClase;
    private String nombreClase;
    private String descripcionClase;
    private String linkZoomClase;
    private Boolean grabarClase;
    private BigInteger asistenciaClase;
    private BigInteger aforoClase;
    private Double costoClase;
    private Double duracionClase;
    private BigInteger valoracionClase;
    private String recursosClase;
    private String materialesClase;
    private Date fechaInicioClase;
    private Date fechaFinClase;
    private Double recargoClase;
    private Double descuentoClase;
    private String zonaHorariaClase;
    private String startUrlClase;
    private String joinUrlClase;
    private String passwordClase;
    private String avatarClase;
    private Boolean activoClase;
    private EstadoClaseDto idEstadoClaseDto;
    private HorarioDto horarioDto;
    private MateriaDto idMateriaDto;
    private TipoClaseDto idTipoClaseDto;
    private TutorDto idTutorDto;
    private Collection<CarritoComprasDto> carritoComprasCollectionDto;
    private Collection<ListaAsistenciaDto> listaAsistenciaCollectionDto;
    private Collection<ReseniasDto> reseniasCollectionDto;
    private Collection<ForoClaseDto> foroClaseCollectionDto;

    public ClaseDto() {
    }
}
