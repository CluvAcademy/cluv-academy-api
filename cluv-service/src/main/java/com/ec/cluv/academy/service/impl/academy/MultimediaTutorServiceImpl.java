package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.MultimediaTutorDto;
import com.ec.cluv.academy.model.mappers.academy.HorasHorarioMapper;
import com.ec.cluv.academy.model.mappers.academy.MultimediaTutorMapper;
import com.ec.cluv.academy.repository.academy.MultimediaTutorRepository;
import com.ec.cluv.academy.service.service.academy.MultimediaTutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class MultimediaTutorServiceImpl implements MultimediaTutorService {

    @Autowired
    private MultimediaTutorRepository repository;

    @Autowired
    private MultimediaTutorMapper mapper;

    @Override
    public MultimediaTutorDto create(MultimediaTutorDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<MultimediaTutorDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public MultimediaTutorDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
