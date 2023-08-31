package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.EstadoCarritoComprasDto;
import com.ec.cluv.academy.model.mappers.academy.EstadoActividadTutorMapper;
import com.ec.cluv.academy.model.mappers.academy.EstadoCarritoComprasMapper;
import com.ec.cluv.academy.repository.academy.EstadoCarritoComprasRepository;
import com.ec.cluv.academy.service.service.academy.EstadoCarritoComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class EstadoCarritoComprasServiceImpl implements EstadoCarritoComprasService {

    @Autowired
    private EstadoCarritoComprasRepository repository;

    @Autowired
    private EstadoCarritoComprasMapper mapper;
    
    @Override
    public EstadoCarritoComprasDto create(EstadoCarritoComprasDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<EstadoCarritoComprasDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public EstadoCarritoComprasDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
