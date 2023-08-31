package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.HorasHorarioDto;
import com.ec.cluv.academy.model.mappers.academy.ForoTutorMapper;
import com.ec.cluv.academy.model.mappers.academy.HorasHorarioMapper;
import com.ec.cluv.academy.repository.academy.HorasHorarioRepository;
import com.ec.cluv.academy.service.service.academy.HorasHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class HorasHorarioServiceImpl implements HorasHorarioService {

    @Autowired
    private HorasHorarioRepository repository;

    @Autowired
    private HorasHorarioMapper mapper;

    @Override
    public HorasHorarioDto create(HorasHorarioDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<HorasHorarioDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public HorasHorarioDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
