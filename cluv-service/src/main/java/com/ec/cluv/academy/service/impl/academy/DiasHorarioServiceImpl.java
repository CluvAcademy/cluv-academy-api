package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.DiasHorarioDto;
import com.ec.cluv.academy.model.mappers.academy.ClubMapper;
import com.ec.cluv.academy.model.mappers.academy.DiasHorarioMapper;
import com.ec.cluv.academy.repository.academy.DiasHorarioRepository;
import com.ec.cluv.academy.service.service.academy.DiasHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class DiasHorarioServiceImpl implements DiasHorarioService {

    @Autowired
    private DiasHorarioRepository repository;

    @Autowired
    private DiasHorarioMapper mapper;

    @Override
    public DiasHorarioDto create(DiasHorarioDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<DiasHorarioDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public DiasHorarioDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
