package com.ec.cluv.academy.service.impl.publick;

import com.ec.cluv.academy.model.dto.publick.RefreshTokenDto;
import com.ec.cluv.academy.model.mappers.publick.RefreshTokenMapper;
import com.ec.cluv.academy.repository.publick.RefreshTokenRepository;
import com.ec.cluv.academy.service.service.publick.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class RefreshTokenServiceImpl implements RefreshTokenService {

    @Autowired
    private RefreshTokenRepository repository;

    @Autowired
    private RefreshTokenMapper mapper;

    @Override
    public List<RefreshTokenDto> listar() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public RefreshTokenDto registrar(RefreshTokenDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public RefreshTokenDto buscarPorId(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }
}
