package com.ec.cluv.academy.repository.academy;

import com.ec.cluv.academy.model.dto.auxiliares.TutorLandingDto;
import com.ec.cluv.academy.model.entities.academy.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {


    @Query("select new com.ec.cluv.academy.model.dto.auxiliares.TutorLandingDto(u.nombres, u.avatar, t.sobremiTutor) from Tutor t join Usuario u on t.idUsuarioTutor=u.idUsuario where u.activo = 'SI' and t.activoTutor = true ")
    List<TutorLandingDto> getAllTutorLandingDto();
}
