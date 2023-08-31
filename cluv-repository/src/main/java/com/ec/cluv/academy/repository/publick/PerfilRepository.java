package com.ec.cluv.academy.repository.publick;

import com.ec.cluv.academy.model.entities.publick.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

}
