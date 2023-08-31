package com.ec.cluv.academy.service.impl.publick;


import com.ec.cluv.academy.model.dto.publick.PerfilDto;
import com.ec.cluv.academy.model.dto.publick.PerfilUsuarioDto;
import com.ec.cluv.academy.model.dto.publick.PerfilUsuarioPKDto;
import com.ec.cluv.academy.model.entities.publick.Perfil;
import com.ec.cluv.academy.model.entities.publick.PerfilUsuario;
import com.ec.cluv.academy.model.entities.publick.PerfilUsuarioPK;
import com.ec.cluv.academy.model.mappers.publick.PerfilMapper;
import com.ec.cluv.academy.model.mappers.publick.PerfilUsuarioMapper;
import com.ec.cluv.academy.model.mappers.publick.UsuarioMapper;
import com.ec.cluv.academy.repository.publick.PerfilUsuarioRepository;
import com.ec.cluv.academy.service.service.publick.PerfilUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class PerfilUsuarioServiceImpl implements PerfilUsuarioService {

    @Autowired
    private PerfilUsuarioRepository repository;

    @Autowired
    private PerfilUsuarioMapper mapper;

    @Autowired
    private PerfilMapper perfilMapper;

    @Autowired
    private PerfilMapper mapperPerfil;


    @Override
    public PerfilUsuarioDto create(PerfilUsuarioDto obj) {

        PerfilUsuario pu = new PerfilUsuario();
        PerfilUsuarioPK pk = new PerfilUsuarioPK();

        pk.setIdPerfil(obj.getPerfilDto().getIdPerfil());
        pk.setIdUsuario(obj.getUsuarioDto().getIdUsuario());

        pu.setPerfilUsuarioPK(pk);

        pu.setPerfil(perfilMapper.toEntity(obj.getPerfilDto()));
        pu.setUsuario(UsuarioMapper.INSTANCE.toEntity(obj.getUsuarioDto()));

        return mapper.toDto(repository.save(pu));
    }

    @Override
    public List<PerfilUsuarioDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public PerfilUsuarioDto findById(PerfilUsuarioPKDto id) {
        PerfilUsuarioPK pk = new PerfilUsuarioPK();
        pk.setIdPerfil(id.getIdPerfil());
        pk.setIdUsuario(id.getIdUsuario());
        return mapper.toDto(repository.findById(pk).isPresent() ? repository.findById(pk).get() : null);
    }

    @Override
    public boolean delete(PerfilUsuarioPKDto id) {
        PerfilUsuarioPK pk = new PerfilUsuarioPK();
        pk.setIdPerfil(id.getIdPerfil());
        pk.setIdUsuario(id.getIdUsuario());
        repository.deleteById(pk);
        return repository.findById(pk).isPresent();
    }

    @Override
    public List<PerfilDto> obtenerPorUsername(String username) {
        List<Perfil> list = repository.getPerfilesByUser(username);
        return mapperPerfil.toDto(list);
    }
}
