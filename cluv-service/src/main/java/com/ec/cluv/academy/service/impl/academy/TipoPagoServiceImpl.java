package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.TipoPagoDto;
import com.ec.cluv.academy.model.mappers.academy.HorasHorarioMapper;
import com.ec.cluv.academy.model.mappers.academy.TipoPagoMapper;
import com.ec.cluv.academy.repository.academy.TipoPagoRepository;
import com.ec.cluv.academy.service.service.academy.TipoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class TipoPagoServiceImpl implements TipoPagoService {

    @Autowired
    private TipoPagoRepository repository;

    @Autowired
    private TipoPagoMapper mapper;

    @Override
    public TipoPagoDto create(TipoPagoDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<TipoPagoDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public TipoPagoDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
