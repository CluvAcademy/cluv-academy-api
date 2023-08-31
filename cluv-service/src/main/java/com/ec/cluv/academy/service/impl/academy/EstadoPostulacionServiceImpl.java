package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.EstadoPostulacionDto;
import com.ec.cluv.academy.model.mappers.academy.EstadoHorarioMapper;
import com.ec.cluv.academy.model.mappers.academy.EstadoPostulacionMapper;
import com.ec.cluv.academy.repository.academy.EstadoPostulacionRepository;
import com.ec.cluv.academy.service.service.academy.EstadoPostulacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class EstadoPostulacionServiceImpl implements EstadoPostulacionService {

    @Autowired
    private EstadoPostulacionRepository repository;

    @Autowired
    private EstadoPostulacionMapper mapper;
    
    @Override
    public EstadoPostulacionDto create(EstadoPostulacionDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<EstadoPostulacionDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public EstadoPostulacionDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
