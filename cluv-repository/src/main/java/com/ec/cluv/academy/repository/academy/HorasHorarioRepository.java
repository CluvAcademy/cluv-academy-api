package com.ec.cluv.academy.repository.academy;

import com.ec.cluv.academy.model.entities.academy.HorasHorario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorasHorarioRepository extends JpaRepository<HorasHorario, Long> {

}
