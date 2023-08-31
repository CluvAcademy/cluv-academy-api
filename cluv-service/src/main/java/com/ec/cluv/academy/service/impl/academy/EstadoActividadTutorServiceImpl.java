package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.EstadoActividadTutorDto;
import com.ec.cluv.academy.model.mappers.academy.DiasHorarioMapper;
import com.ec.cluv.academy.model.mappers.academy.EstadoActividadTutorMapper;
import com.ec.cluv.academy.repository.academy.EstadoActividadTutorRepository;
import com.ec.cluv.academy.service.service.academy.EstadoActividadTutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class EstadoActividadTutorServiceImpl implements EstadoActividadTutorService {

    @Autowired
    private EstadoActividadTutorRepository repository;

    @Autowired
    private EstadoActividadTutorMapper mapper;

    @Override
    public EstadoActividadTutorDto create(EstadoActividadTutorDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<EstadoActividadTutorDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public EstadoActividadTutorDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
