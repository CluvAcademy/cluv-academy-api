package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.HorarioSugeridoTutorDto;
import com.ec.cluv.academy.model.mappers.academy.ForoTutorMapper;
import com.ec.cluv.academy.model.mappers.academy.HorarioSugeridoTutorMapper;
import com.ec.cluv.academy.repository.academy.HorarioSugeridoTutorRepository;
import com.ec.cluv.academy.service.service.academy.HorarioSugeridoTutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class HorarioSugeridoTutorServiceImpl implements HorarioSugeridoTutorService {

    @Autowired
    private HorarioSugeridoTutorRepository repository;

    @Autowired
    private HorarioSugeridoTutorMapper mapper;

    @Override
    public HorarioSugeridoTutorDto create(HorarioSugeridoTutorDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<HorarioSugeridoTutorDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public HorarioSugeridoTutorDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
