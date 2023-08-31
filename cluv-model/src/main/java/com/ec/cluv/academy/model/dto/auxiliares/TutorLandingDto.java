package com.ec.cluv.academy.model.dto.auxiliares;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class TutorLandingDto implements Serializable {
    private String nombres;
    private String avatar;
    private String sobreMi;

    public TutorLandingDto(){}
}
