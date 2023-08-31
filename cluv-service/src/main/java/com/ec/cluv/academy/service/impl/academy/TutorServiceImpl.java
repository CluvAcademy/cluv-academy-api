package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.TutorDto;
import com.ec.cluv.academy.model.dto.auxiliares.TutorLandingDto;
import com.ec.cluv.academy.model.mappers.academy.HorasHorarioMapper;
import com.ec.cluv.academy.model.mappers.academy.TutorMapper;
import com.ec.cluv.academy.repository.academy.TutorRepository;
import com.ec.cluv.academy.service.service.academy.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class TutorServiceImpl implements TutorService {

    @Autowired
    private TutorRepository repository;

    @Autowired
    private TutorMapper mapper;

    @Override
    public TutorDto create(TutorDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<TutorDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public TutorDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }

    @Override
    public List<TutorLandingDto> getAllTutorLandingDto() {
        return repository.getAllTutorLandingDto();
    }
}
