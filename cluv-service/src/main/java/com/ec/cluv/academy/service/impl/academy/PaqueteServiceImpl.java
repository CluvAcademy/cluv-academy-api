package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.PaqueteDto;
import com.ec.cluv.academy.model.mappers.academy.HorasHorarioMapper;
import com.ec.cluv.academy.model.mappers.academy.PaqueteMapper;
import com.ec.cluv.academy.repository.academy.PaqueteRepository;
import com.ec.cluv.academy.service.service.academy.PaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class PaqueteServiceImpl implements PaqueteService {

    @Autowired
    private PaqueteRepository repository;

    @Autowired
    private PaqueteMapper mapper;

    @Override
    public PaqueteDto create(PaqueteDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<PaqueteDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public PaqueteDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
