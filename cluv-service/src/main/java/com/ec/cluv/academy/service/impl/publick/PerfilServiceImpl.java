package com.ec.cluv.academy.service.impl.publick;



import com.ec.cluv.academy.model.dto.publick.PerfilDto;
import com.ec.cluv.academy.model.mappers.publick.PerfilMapper;
import com.ec.cluv.academy.repository.publick.PerfilRepository;
import com.ec.cluv.academy.service.service.publick.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository repository;

    @Autowired
    private PerfilMapper mapper;


    @Override
    public PerfilDto create(PerfilDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<PerfilDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public PerfilDto findById(Integer id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Integer id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
