package com.ec.cluv.academy.repository.publick;

import com.ec.cluv.academy.model.entities.publick.Perfil;
import com.ec.cluv.academy.model.entities.publick.PerfilUsuario;
import com.ec.cluv.academy.model.entities.publick.PerfilUsuarioPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario, PerfilUsuarioPK> {

    @Query("select p from Perfil p where p.idPerfil in (select u.perfil.idPerfil from PerfilUsuario u where u.usuario.nombreUsuario=?1)")
    public List<Perfil> getPerfilesByUser(@Param("username") String username);
}
