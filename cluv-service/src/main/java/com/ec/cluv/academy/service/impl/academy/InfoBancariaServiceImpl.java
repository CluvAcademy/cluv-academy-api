package com.ec.cluv.academy.service.impl.academy;

import com.ec.cluv.academy.model.dto.academy.InfoBancariaDto;
import com.ec.cluv.academy.model.mappers.academy.HorasHorarioMapper;
import com.ec.cluv.academy.model.mappers.academy.InfoBancariaMapper;
import com.ec.cluv.academy.repository.academy.InfoBancariaTutorRepository;
import com.ec.cluv.academy.service.service.academy.InfoBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class InfoBancariaServiceImpl implements InfoBancariaService {

    @Autowired
    private InfoBancariaTutorRepository repository;

    @Autowired
    private InfoBancariaMapper mapper;

    @Override
    public InfoBancariaDto create(InfoBancariaDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<InfoBancariaDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public InfoBancariaDto findById(Long id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }
}
