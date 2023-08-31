package com.ec.cluv.academy.repository.academy;

import com.ec.cluv.academy.model.entities.academy.Logros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogrosRepository extends JpaRepository<Logros, Long> {

}
