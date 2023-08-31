package com.ec.cluv.academy.repository.academy;

import com.ec.cluv.academy.model.entities.academy.Horario;
import com.ec.cluv.academy.model.entities.academy.HorarioPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, HorarioPK> {

}
