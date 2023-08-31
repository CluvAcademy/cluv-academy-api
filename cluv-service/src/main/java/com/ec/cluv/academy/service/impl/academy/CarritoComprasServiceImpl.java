package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.CarritoComprasDto;
import com.ec.cluv.academy.model.mappers.academy.CalificacionTutorMapper;
import com.ec.cluv.academy.model.mappers.academy.CarritoComprasMapper;
import com.ec.cluv.academy.repository.academy.CarritoComprasRepository;
import com.ec.cluv.academy.service.service.academy.CarritoComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class CarritoComprasServiceImpl implements CarritoComprasService {

    @Autowired
    private CarritoComprasRepository repository;

    @Autowired
    private CarritoComprasMapper mapper;

    @Override
    public CarritoComprasDto create(CarritoComprasDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<CarritoComprasDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public CarritoComprasDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
