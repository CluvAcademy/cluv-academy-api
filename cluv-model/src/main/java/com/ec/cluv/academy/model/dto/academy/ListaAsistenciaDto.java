package com.ec.cluv.academy.model.dto.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
public class ListaAsistenciaDto implements Serializable {
    private Long idListaAsistencia;

    private BigInteger idEstudianteAsistencia;

    private Date fechaReistroListaAsistencia;

    private ClaseDto idClaseDto;

    public ListaAsistenciaDto() {
    }
}
