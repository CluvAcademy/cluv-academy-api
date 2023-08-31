package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.EstudianteDto;
import com.ec.cluv.academy.model.entities.academy.Estudiante;
import com.ec.cluv.academy.model.mappers.academy.EstudianteMapper;
import com.ec.cluv.academy.repository.academy.EstudianteRepository;
import com.ec.cluv.academy.service.service.academy.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    @Autowired
    private EstudianteMapper mapper;


    @Override
    public EstudianteDto create(EstudianteDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<EstudianteDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public EstudianteDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
