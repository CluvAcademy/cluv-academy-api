package com.ec.cluv.academy.model.dto.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@AllArgsConstructor
public class ReseniasDto implements Serializable {

    private Long idResenias;
    private String descripcionResenias;
    private BigInteger idEstudianteResenias;
    private BigInteger valorResenias;
    private ClaseDto idClaseDto;

    public ReseniasDto() {
    }
}
