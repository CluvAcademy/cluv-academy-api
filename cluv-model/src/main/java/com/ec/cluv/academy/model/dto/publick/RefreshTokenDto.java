package com.ec.cluv.academy.model.dto.publick;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
public class RefreshTokenDto implements Serializable {

    private long id;

    private UsuarioDto userDto;

    private String token;

    private Instant expira;

    public RefreshTokenDto() {
    }


}
