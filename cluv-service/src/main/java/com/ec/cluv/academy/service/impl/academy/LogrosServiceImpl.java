package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.LogrosDto;
import com.ec.cluv.academy.model.mappers.academy.HorasHorarioMapper;
import com.ec.cluv.academy.model.mappers.academy.LogrosMapper;
import com.ec.cluv.academy.repository.academy.LogrosRepository;
import com.ec.cluv.academy.service.service.academy.LogrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class LogrosServiceImpl implements LogrosService {

    @Autowired
    private LogrosRepository repository;

    @Autowired
    private LogrosMapper mapper;

    @Override
    public LogrosDto create(LogrosDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<LogrosDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public LogrosDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
