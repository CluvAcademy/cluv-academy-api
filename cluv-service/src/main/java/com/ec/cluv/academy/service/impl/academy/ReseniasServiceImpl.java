package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.ReseniasDto;
import com.ec.cluv.academy.model.mappers.academy.HorasHorarioMapper;
import com.ec.cluv.academy.model.mappers.academy.ReseniasMapper;
import com.ec.cluv.academy.repository.academy.ReseniasRepository;
import com.ec.cluv.academy.service.service.academy.ReseniasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ReseniasServiceImpl implements ReseniasService {

    @Autowired
    private ReseniasRepository repository;

    @Autowired
    private ReseniasMapper mapper;

    @Override
    public ReseniasDto create(ReseniasDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<ReseniasDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public ReseniasDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
