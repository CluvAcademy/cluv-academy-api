package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.SilaboDto;
import com.ec.cluv.academy.model.mappers.academy.HorasHorarioMapper;
import com.ec.cluv.academy.model.mappers.academy.SilaboMapper;
import com.ec.cluv.academy.repository.academy.SilaboRepository;
import com.ec.cluv.academy.service.service.academy.SilaboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class SilaboServiceImpl implements SilaboService {

    @Autowired
    private SilaboRepository repository;

    @Autowired
    private SilaboMapper mapper;

    @Override
    public SilaboDto create(SilaboDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<SilaboDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public SilaboDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
