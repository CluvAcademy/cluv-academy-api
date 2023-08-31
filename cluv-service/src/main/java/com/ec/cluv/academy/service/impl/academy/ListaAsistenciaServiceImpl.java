package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.ListaAsistenciaDto;
import com.ec.cluv.academy.model.mappers.academy.HorasHorarioMapper;
import com.ec.cluv.academy.model.mappers.academy.ListaAsistenciaMapper;
import com.ec.cluv.academy.repository.academy.ListaAsistenciaRepository;
import com.ec.cluv.academy.service.service.academy.ListaAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ListaAsistenciaServiceImpl implements ListaAsistenciaService {

    @Autowired
    private ListaAsistenciaRepository repository;

    @Autowired
    private ListaAsistenciaMapper mapper;

    @Override
    public ListaAsistenciaDto create(ListaAsistenciaDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<ListaAsistenciaDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public ListaAsistenciaDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
