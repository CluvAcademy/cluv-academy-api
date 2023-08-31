package com.ec.cluv.academy.repository.publick;

import com.ec.cluv.academy.model.entities.publick.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("Select u from Usuario u where u.nombreUsuario = ?1 and u.activo = 'SI'")
    public Usuario findByNombreUsuario(String nombreUsuario);

    public Usuario findByCedula(String cedula);

    public boolean existsByCedula(String cedula);



}
