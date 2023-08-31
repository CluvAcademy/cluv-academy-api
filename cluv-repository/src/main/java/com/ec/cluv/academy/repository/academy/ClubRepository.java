package com.ec.cluv.academy.repository.academy;

import com.ec.cluv.academy.model.dto.auxiliares.ClubLandingDto;
import com.ec.cluv.academy.model.dto.auxiliares.TutorLandingDto;
import com.ec.cluv.academy.model.entities.academy.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

    @Query("select new com.ec.cluv.academy.model.dto.auxiliares.ClubLandingDto(c.nombreClub, c.avatarClub, c.introduccionClub, c.descripcionClub, c.idReconocimientoClub.nombreReconocimientoClub) from Club c where c.activoClub = true ")
    List<ClubLandingDto> getAllClubLandingDto();
}
