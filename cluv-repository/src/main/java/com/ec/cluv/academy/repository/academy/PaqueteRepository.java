package com.ec.cluv.academy.repository.academy;

import com.ec.cluv.academy.model.entities.academy.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaqueteRepository extends JpaRepository<Paquete, Long> {

}
