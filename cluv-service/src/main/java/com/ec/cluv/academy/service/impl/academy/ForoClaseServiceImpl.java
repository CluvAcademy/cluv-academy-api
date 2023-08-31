package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.ForoClaseDto;
import com.ec.cluv.academy.model.mappers.academy.FacturaMapper;
import com.ec.cluv.academy.model.mappers.academy.ForoClaseMapper;
import com.ec.cluv.academy.repository.academy.ForoClaseRepository;
import com.ec.cluv.academy.service.service.academy.ForoClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ForoClaseServiceImpl implements ForoClaseService {

    @Autowired
    private ForoClaseRepository repository;

    @Autowired
    private ForoClaseMapper mapper;

    @Override
    public ForoClaseDto create(ForoClaseDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<ForoClaseDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public ForoClaseDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
