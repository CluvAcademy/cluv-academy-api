package com.ec.cluv.academy.repository.academy;

import com.ec.cluv.academy.model.entities.academy.InfoAcademicaTutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoAcademicaTutorRepository extends JpaRepository<InfoAcademicaTutor, Long> {

}
