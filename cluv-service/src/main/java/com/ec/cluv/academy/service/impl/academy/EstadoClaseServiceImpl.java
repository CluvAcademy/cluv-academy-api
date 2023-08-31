package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.EstadoClaseDto;
import com.ec.cluv.academy.model.mappers.academy.EstadoCarritoComprasMapper;
import com.ec.cluv.academy.model.mappers.academy.EstadoClaseMapper;
import com.ec.cluv.academy.repository.academy.EstadoClaseRepository;
import com.ec.cluv.academy.service.service.academy.EstadoClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class EstadoClaseServiceImpl implements EstadoClaseService {

    @Autowired
    private EstadoClaseRepository repository;

    @Autowired
    private EstadoClaseMapper mapper;
    
    @Override
    public EstadoClaseDto create(EstadoClaseDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<EstadoClaseDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public EstadoClaseDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
