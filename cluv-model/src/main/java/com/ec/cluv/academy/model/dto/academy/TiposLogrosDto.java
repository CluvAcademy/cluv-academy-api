package com.ec.cluv.academy.model.dto.academy;

import com.ec.cluv.academy.model.entities.academy.Logros;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

@Data
@AllArgsConstructor
public class TiposLogrosDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idTipoLogro;
    private String nombreTipoLogro;
    private String descripcionTipoLogro;
    private Boolean activoTipoLogro;
    private Collection<LogrosDto> logrosCollectionDto;

    public TiposLogrosDto() {
    }
}
