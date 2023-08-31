package com.ec.cluv.academy.model.dto.auxiliares;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@AllArgsConstructor
public class ClaseLandingDto implements Serializable {
    private String nombre;
    private String descripcion;
    private String estado;
    private BigInteger aforo;
    private BigInteger reservas;
    private String avatarClase;
    private BigInteger valoracion;
    private Double costo;
    private String nombreTutor;
    private String avatarTutor;
    private String sobreMiTutor;

    public ClaseLandingDto(){}
}
