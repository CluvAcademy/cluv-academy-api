package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.TipoPaqueteDto;
import com.ec.cluv.academy.model.entities.academy.TipoPaquete;
import com.ec.cluv.academy.model.mappers.academy.HorasHorarioMapper;
import com.ec.cluv.academy.model.mappers.academy.TipoPaqueteMapper;
import com.ec.cluv.academy.repository.academy.TipoPaqueteRepository;
import com.ec.cluv.academy.service.service.academy.TipoPaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class TipoPaqueteServiceImpl implements TipoPaqueteService {

    @Autowired
    private TipoPaqueteRepository repository;

    @Autowired
    private TipoPaqueteMapper mapper;

    @Override
    public TipoPaqueteDto create(TipoPaqueteDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<TipoPaqueteDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public TipoPaqueteDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
