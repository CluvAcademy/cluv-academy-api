package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.EstadoEstudianteDto;
import com.ec.cluv.academy.model.mappers.academy.EstadoClaseMapper;
import com.ec.cluv.academy.model.mappers.academy.EstadoEstudianteMapper;
import com.ec.cluv.academy.repository.academy.EstadoEstudianteRepository;
import com.ec.cluv.academy.service.service.academy.EstadoEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class EstadoEstudianteServiceImpl implements EstadoEstudianteService {

    @Autowired
    private EstadoEstudianteRepository repository;

    @Autowired
    private EstadoEstudianteMapper mapper;
    
    @Override
    public EstadoEstudianteDto create(EstadoEstudianteDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<EstadoEstudianteDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public EstadoEstudianteDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
