package com.ec.cluv.academy.security;

import com.ec.cluv.academy.model.dto.security.UsuarioDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;


public class UsuarioPrincipalFactory {

    public static UsuarioPrincipal build(UsuarioDTO usuario) {
        List<GrantedAuthority> authorities =
                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getId()+":"+rol.getRolNombre())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getId(), usuario.getCedula(),usuario.getUsername(), usuario.getPassword(), authorities);
    }
}
