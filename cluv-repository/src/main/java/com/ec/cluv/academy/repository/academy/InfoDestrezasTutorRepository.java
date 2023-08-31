package com.ec.cluv.academy.repository.academy;

import com.ec.cluv.academy.model.entities.academy.InfoDestrezas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoDestrezasTutorRepository extends JpaRepository<InfoDestrezas, Long> {

}
