package com.ec.cluv.academy.model.dto.security;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class UsuarioDTO implements Serializable {

    private int id;
    private String cedula, username, password;
    private List<RolDTO> roles;

}
