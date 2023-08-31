package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.InfoDestrezasDto;
import com.ec.cluv.academy.model.mappers.academy.HorasHorarioMapper;
import com.ec.cluv.academy.model.mappers.academy.InfoDestrezasMapper;
import com.ec.cluv.academy.repository.academy.InfoDestrezasTutorRepository;
import com.ec.cluv.academy.service.service.academy.InfoDestrezasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class InfoDestrezasServiceImpl implements InfoDestrezasService {

    @Autowired
    private InfoDestrezasTutorRepository repository;

    @Autowired
    private InfoDestrezasMapper mapper;

    @Override
    public InfoDestrezasDto create(InfoDestrezasDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<InfoDestrezasDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public InfoDestrezasDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
