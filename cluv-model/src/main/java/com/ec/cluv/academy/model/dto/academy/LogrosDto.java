package com.ec.cluv.academy.model.dto.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@AllArgsConstructor
public class LogrosDto implements Serializable {
        private static final long serialVersionUID = 1L;

        private Long idLogro;
        private BigInteger idClaseLogro;
        private EstudianteDto idEstudianteDto;
        private TiposLogrosDto idTipoLogroDto;

        public LogrosDto() {
        }
}
