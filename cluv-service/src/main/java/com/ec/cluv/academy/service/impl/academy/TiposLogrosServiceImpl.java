package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.TiposLogrosDto;
import com.ec.cluv.academy.model.mappers.academy.HorasHorarioMapper;
import com.ec.cluv.academy.model.mappers.academy.TiposLogrosMapper;
import com.ec.cluv.academy.repository.academy.TiposLogrosRepository;
import com.ec.cluv.academy.service.service.academy.TiposLogrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class TiposLogrosServiceImpl implements TiposLogrosService {

    @Autowired
    private TiposLogrosRepository repository;

    @Autowired
    private TiposLogrosMapper mapper;

    @Override
    public TiposLogrosDto create(TiposLogrosDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<TiposLogrosDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public TiposLogrosDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
