package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.InfoAcademicaTutorDto;
import com.ec.cluv.academy.model.mappers.academy.HorasHorarioMapper;
import com.ec.cluv.academy.model.mappers.academy.InfoAcademicaTutorMapper;
import com.ec.cluv.academy.repository.academy.InfoAcademicaTutorRepository;
import com.ec.cluv.academy.service.service.academy.InfoAcademicaTutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class InfoAcademicaTutorServiceImpl implements InfoAcademicaTutorService {

    @Autowired
    private InfoAcademicaTutorRepository repository;

    @Autowired
    private InfoAcademicaTutorMapper mapper;

    @Override
    public InfoAcademicaTutorDto create(InfoAcademicaTutorDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<InfoAcademicaTutorDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public InfoAcademicaTutorDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
