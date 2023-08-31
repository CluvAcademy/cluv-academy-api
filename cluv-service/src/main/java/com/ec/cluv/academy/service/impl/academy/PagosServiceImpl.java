package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.PagosDto;
import com.ec.cluv.academy.model.mappers.academy.HorasHorarioMapper;
import com.ec.cluv.academy.model.mappers.academy.PagosMapper;
import com.ec.cluv.academy.repository.academy.PagosRepository;
import com.ec.cluv.academy.service.service.academy.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class PagosServiceImpl implements PagosService {

    @Autowired
    private PagosRepository repository;

    @Autowired
    private PagosMapper mapper;

    @Override
    public PagosDto create(PagosDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<PagosDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public PagosDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
