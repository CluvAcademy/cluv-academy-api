package com.ec.cluv.academy.service.impl.academy;


import com.ec.cluv.academy.model.dto.academy.HorarioDto;
import com.ec.cluv.academy.model.dto.academy.HorarioPKDto;
import com.ec.cluv.academy.model.entities.academy.HorarioPK;
import com.ec.cluv.academy.model.mappers.academy.ForoTutorMapper;
import com.ec.cluv.academy.model.mappers.academy.HorarioMapper;
import com.ec.cluv.academy.repository.academy.HorarioRepository;
import com.ec.cluv.academy.service.service.academy.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class HorarioServiceImpl implements HorarioService {

    @Autowired
    private HorarioRepository repository;

    @Autowired
    private HorarioMapper mapper;

    @Override
    public HorarioDto create(HorarioDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<HorarioDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public HorarioDto findById(HorarioPKDto id) {
        HorarioPK pk = new HorarioPK();
        pk.setIdDiasHorario(id.getIdDiasHorario());
        pk.setIdHorasHorario(id.getIdDiasHorario());
        return mapper.toDto(repository.findById(pk).isPresent() ? repository.findById(pk).get() : null);
    }

    @Override
    public boolean delete(HorarioPKDto id) {
        HorarioPK pk = new HorarioPK();
        pk.setIdDiasHorario(id.getIdDiasHorario());
        pk.setIdHorasHorario(id.getIdDiasHorario());
        repository.deleteById(pk);
        return repository.findById(pk).isPresent();
    }
}
