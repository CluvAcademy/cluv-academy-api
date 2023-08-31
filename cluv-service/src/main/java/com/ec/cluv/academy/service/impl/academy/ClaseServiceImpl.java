package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.ClaseDto;
import com.ec.cluv.academy.model.dto.auxiliares.ClaseLandingDto;
import com.ec.cluv.academy.model.mappers.academy.CarritoComprasMapper;
import com.ec.cluv.academy.model.mappers.academy.ClaseMapper;
import com.ec.cluv.academy.repository.academy.ClaseRepository;
import com.ec.cluv.academy.service.service.academy.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class ClaseServiceImpl implements ClaseService {

    @Autowired
    private ClaseRepository repository;

    @Autowired
    private ClaseMapper mapper;

    @Override
    public ClaseDto create(ClaseDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<ClaseDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public ClaseDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }

    @Override
    public List<ClaseLandingDto> getAllClasesLanding() {
        return repository.getAllClasesLanding().stream().limit(5).collect(Collectors.toList());
    }
}
