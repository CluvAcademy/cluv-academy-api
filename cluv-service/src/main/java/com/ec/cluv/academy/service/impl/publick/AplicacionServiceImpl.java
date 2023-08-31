package com.ec.cluv.academy.service.impl.publick;



import com.ec.cluv.academy.model.dto.publick.AplicacionDto;
import com.ec.cluv.academy.model.mappers.publick.AplicacionMapper;
import com.ec.cluv.academy.repository.publick.AplicacionRepository;
import com.ec.cluv.academy.service.service.publick.AplicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class AplicacionServiceImpl implements AplicacionService {

    @Autowired
    private AplicacionRepository repository;

    @Autowired
    private AplicacionMapper mapper;


    @Override
    public AplicacionDto create(AplicacionDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<AplicacionDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public AplicacionDto findById(Integer id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Integer id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
