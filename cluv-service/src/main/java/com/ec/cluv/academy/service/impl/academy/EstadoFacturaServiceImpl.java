package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.EstadoFacturaDto;
import com.ec.cluv.academy.model.mappers.academy.EstadoEstudianteMapper;
import com.ec.cluv.academy.model.mappers.academy.EstadoFacturaMapper;
import com.ec.cluv.academy.repository.academy.EstadoFacturaRepository;
import com.ec.cluv.academy.service.service.academy.EstadoFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class EstadoFacturaServiceImpl implements EstadoFacturaService {

    @Autowired
    private EstadoFacturaRepository repository;

    @Autowired
    private EstadoFacturaMapper mapper;
    

    @Override
    public EstadoFacturaDto create(EstadoFacturaDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<EstadoFacturaDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public EstadoFacturaDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
