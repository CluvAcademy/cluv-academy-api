package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.ForoTutorDto;
import com.ec.cluv.academy.model.mappers.academy.FacturaMapper;
import com.ec.cluv.academy.model.mappers.academy.ForoTutorMapper;
import com.ec.cluv.academy.repository.academy.ForoTutorRepository;
import com.ec.cluv.academy.service.service.academy.ForoTutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ForoTutorServiceImpl implements ForoTutorService {

    @Autowired
    private ForoTutorRepository repository;

    @Autowired
    private ForoTutorMapper mapper;

    @Override
    public ForoTutorDto create(ForoTutorDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<ForoTutorDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public ForoTutorDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
