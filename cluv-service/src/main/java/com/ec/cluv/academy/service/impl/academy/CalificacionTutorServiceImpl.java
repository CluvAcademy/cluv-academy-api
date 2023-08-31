package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.CalificacionTutorDto;
import com.ec.cluv.academy.model.entities.academy.CalificacionTutor;
import com.ec.cluv.academy.model.mappers.academy.CalificacionClubMapper;
import com.ec.cluv.academy.model.mappers.academy.CalificacionTutorMapper;
import com.ec.cluv.academy.repository.academy.CalificacionTutorRepository;
import com.ec.cluv.academy.service.service.academy.CalificacionTutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class CalificacionTutorServiceImpl implements CalificacionTutorService {

    @Autowired
    private CalificacionTutorRepository repository;

    @Autowired
    private CalificacionTutorMapper mapper;

    @Override
    public CalificacionTutorDto create(CalificacionTutorDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<CalificacionTutorDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public CalificacionTutorDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
