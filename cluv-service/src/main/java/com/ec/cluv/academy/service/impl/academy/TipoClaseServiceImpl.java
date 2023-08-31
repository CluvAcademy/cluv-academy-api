package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.TipoClaseDto;
import com.ec.cluv.academy.model.mappers.academy.HorasHorarioMapper;
import com.ec.cluv.academy.model.mappers.academy.TipoClaseMapper;
import com.ec.cluv.academy.repository.academy.TipoClaseRepository;
import com.ec.cluv.academy.service.service.academy.TipoClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class TipoClaseServiceImpl implements TipoClaseService {

    @Autowired
    private TipoClaseRepository repository;

    @Autowired
    private TipoClaseMapper mapper;

    @Override
    public TipoClaseDto create(TipoClaseDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<TipoClaseDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public TipoClaseDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
