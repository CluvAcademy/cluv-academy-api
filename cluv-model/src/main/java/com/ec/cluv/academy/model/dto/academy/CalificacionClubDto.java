package com.ec.cluv.academy.model.dto.academy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@AllArgsConstructor
public class CalificacionClubDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idCalificacionClub;
    private BigInteger valorCalificacionClub;
    private ClubDto idClubDto;

    public CalificacionClubDto() {
    }
}
