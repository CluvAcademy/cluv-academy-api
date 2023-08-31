package com.ec.cluv.academy.service.impl.publick;



import com.ec.cluv.academy.model.dto.publick.AutorizacionDto;
import com.ec.cluv.academy.model.mappers.publick.AutorizacionMapper;
import com.ec.cluv.academy.repository.publick.AutorizacionRepository;
import com.ec.cluv.academy.service.service.publick.AutorizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class AutorizacionServiceImpl implements AutorizacionService {

    @Autowired
    private AutorizacionRepository repository;

    @Autowired
    private AutorizacionMapper mapper;


    @Override
    public AutorizacionDto create(AutorizacionDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<AutorizacionDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public AutorizacionDto findById(Integer id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Integer id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
