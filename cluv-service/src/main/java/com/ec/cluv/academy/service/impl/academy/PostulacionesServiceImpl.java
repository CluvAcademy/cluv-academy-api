package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.PostulacionesDto;
import com.ec.cluv.academy.model.mappers.academy.HorasHorarioMapper;
import com.ec.cluv.academy.model.mappers.academy.PostulacionesMapper;
import com.ec.cluv.academy.repository.academy.PostulacionesRepository;
import com.ec.cluv.academy.service.service.academy.PostulacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class PostulacionesServiceImpl implements PostulacionesService {

    @Autowired
    private PostulacionesRepository repository;

    @Autowired
    private PostulacionesMapper mapper;

    @Override
    public PostulacionesDto create(PostulacionesDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<PostulacionesDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public PostulacionesDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
