package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.ClubDto;
import com.ec.cluv.academy.model.dto.auxiliares.ClubLandingDto;
import com.ec.cluv.academy.model.mappers.academy.ClaseMapper;
import com.ec.cluv.academy.model.mappers.academy.ClubMapper;
import com.ec.cluv.academy.repository.academy.ClubRepository;
import com.ec.cluv.academy.service.service.academy.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepository repository;

    @Autowired
    private ClubMapper mapper;
    
    @Override
    public ClubDto create(ClubDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<ClubDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public ClubDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }

    @Override
    public List<ClubLandingDto> getAllClubLandingDto() {
        return repository.getAllClubLandingDto();
    }
}
