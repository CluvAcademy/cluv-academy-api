package com.ec.cluv.academy.repository.academy;

import com.ec.cluv.academy.model.dto.auxiliares.ClaseLandingDto;
import com.ec.cluv.academy.model.entities.academy.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Long> {

    @Query("select new com.ec.cluv.academy.model.dto.auxiliares.ClaseLandingDto(c.nombreClase, c.descripcionClase, c.idEstadoClase.nombreEstadoClase, c.aforoClase, c.asistenciaClase, c.avatarClase, c.valoracionClase, c.costoClase, u.nombres, u.avatar, t.sobremiTutor)  from Clase c join Tutor t on c.idTutor.idTutor=t.idTutor join Usuario u on t.idUsuarioTutor=u.idUsuario where c.activoClase = true ")
    List<ClaseLandingDto> getAllClasesLanding();
}
