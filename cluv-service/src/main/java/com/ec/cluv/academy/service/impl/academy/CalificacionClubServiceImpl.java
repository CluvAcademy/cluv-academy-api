package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.CalificacionClubDto;
import com.ec.cluv.academy.model.mappers.academy.CalificacionClubMapper;
import com.ec.cluv.academy.repository.academy.CalificacionClubRepository;
import com.ec.cluv.academy.service.service.academy.CalificacionClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class CalificacionClubServiceImpl implements CalificacionClubService {

    @Autowired
    private CalificacionClubRepository repository;
    
    @Autowired
    private CalificacionClubMapper mapper;

    @Override
    public CalificacionClubDto create(CalificacionClubDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<CalificacionClubDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public CalificacionClubDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
