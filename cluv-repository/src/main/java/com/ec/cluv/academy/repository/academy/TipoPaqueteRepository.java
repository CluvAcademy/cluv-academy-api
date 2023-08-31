package com.ec.cluv.academy.repository.academy;

import com.ec.cluv.academy.model.entities.academy.TipoPaquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPaqueteRepository extends JpaRepository<TipoPaquete, Long> {

}
