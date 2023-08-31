package com.ec.cluv.academy.service.impl.publick;


import com.ec.cluv.academy.model.dto.publick.UsuarioDto;
import com.ec.cluv.academy.model.entities.publick.Usuario;
import com.ec.cluv.academy.model.mappers.publick.UsuarioMapper;
import com.ec.cluv.academy.repository.publick.UsuarioRepository;
import com.ec.cluv.academy.service.service.publick.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UsuarioDto create(UsuarioDto obj) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(obj.getClave());
        obj.setClave(encodedPassword);
        return UsuarioMapper.INSTANCE.toDto(repository.save(UsuarioMapper.INSTANCE.toEntity(obj)));
    }

    @Override
    public List<UsuarioDto> findAll() {
        return UsuarioMapper.INSTANCE.toDto(repository.findAll());
    }

    @Override
    public UsuarioDto findById(Integer id) {
        return UsuarioMapper.INSTANCE.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Integer id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }

    @Override
    public UsuarioDto findByNombreUsuario(String username) {
        Usuario obj = repository.findByNombreUsuario(username);
        return UsuarioMapper.INSTANCE.toDto(obj);
    }

    @Override
    public UsuarioDto findByDni(String dni) {
        Usuario obj = repository.findByCedula(dni);
        return UsuarioMapper.INSTANCE.toDto(obj);
    }
}
