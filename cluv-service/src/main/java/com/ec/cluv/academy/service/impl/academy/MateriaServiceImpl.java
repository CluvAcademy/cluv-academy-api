package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.MateriaDto;
import com.ec.cluv.academy.model.mappers.academy.HorasHorarioMapper;
import com.ec.cluv.academy.model.mappers.academy.MateriaMapper;
import com.ec.cluv.academy.repository.academy.MateriaRepository;
import com.ec.cluv.academy.service.service.academy.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class MateriaServiceImpl implements MateriaService {

    @Autowired
    private MateriaRepository repository;

    @Autowired
    private MateriaMapper mapper;

    @Override
    public MateriaDto create(MateriaDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<MateriaDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public MateriaDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
