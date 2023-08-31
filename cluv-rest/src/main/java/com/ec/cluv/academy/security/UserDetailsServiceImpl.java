package com.ec.cluv.academy.security;

import com.ec.cluv.academy.model.dto.publick.PerfilDto;
import com.ec.cluv.academy.model.dto.publick.UsuarioDto;
import com.ec.cluv.academy.model.dto.security.RolDTO;
import com.ec.cluv.academy.model.dto.security.UsuarioDTO;
import com.ec.cluv.academy.service.service.publick.PerfilUsuarioService;
import com.ec.cluv.academy.service.service.publick.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    PerfilUsuarioService usuarioPerfilService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioDto usuario = usuarioService.findByNombreUsuario(username);
        List<PerfilDto> listPerfil = usuarioPerfilService.obtenerPorUsername(usuario.getNombreUsuario());


        UsuarioDTO userDTO = new UsuarioDTO();
        userDTO.setId(usuario.getIdUsuario());
        userDTO.setCedula(usuario.getCedula());
        userDTO.setUsername(usuario.getNombreUsuario());
        userDTO.setPassword(usuario.getClave());

        List<RolDTO> listRolesDTO = new ArrayList<>();
        for (PerfilDto p : listPerfil) {
            RolDTO rolDto = new RolDTO();
            rolDto.setId(p.getIdPerfil());
            rolDto.setRolNombre(p.getNombre());

            listRolesDTO.add(rolDto);
        }

        userDTO.setRoles(listRolesDTO);

        return UsuarioPrincipalFactory.build(userDTO);

    }
}
