package com.ec.cluv.academy.repository.publick;

import com.ec.cluv.academy.model.entities.publick.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    @Query("select m from Menu m " +
            "join Autorizacion  a on  m.idMenu=a.idMenu.idMenu " +
            "join PerfilUsuario up on a.idPerfil.idPerfil = up.perfilUsuarioPK.idPerfil " +
            "where up.usuario.nombreUsuario =:username order by m.orden")
    List<Menu> findByUsername(@Param("username") String username);

    @Query("select m from Menu m " +
            "join Autorizacion  a on  m.idMenu=a.idMenu.idMenu " +
            "join PerfilUsuario up on a.idPerfil.idPerfil = up.perfilUsuarioPK.idPerfil " +
            "where m.tipo='menu' and m.activo='SI' " +
            "and up.usuario.nombreUsuario =:username group by m.idMenu order by m.orden")
    List<Menu> findPadreByUsername(@Param("username") String username);

    @Query("select m from Menu m " +
            "join Autorizacion  a on  m.idMenu=a.idMenu.idMenu " +
            "join PerfilUsuario up on a.idPerfil.idPerfil = up.perfilUsuarioPK.idPerfil " +
            "where m.tipo='opcion' and m.activo = 'SI' and m.idMenuPadre.idMenu=:menuPadre " +
            "and up.usuario.nombreUsuario =:username order by m.orden")
    List<Menu> findHijoByMenuPadreAndUsername(@Param("menuPadre") Integer menuPadre, @Param("username") String username);


    @Query("select m from Menu m " +
            "join Autorizacion  a on  m.idMenu=a.idMenu.idMenu " +
            "join PerfilUsuario up on a.idPerfil.idPerfil = up.perfilUsuarioPK.idPerfil " +
            "where m.activo = 'SI' and m.idMenuPadre.idMenu=:menuPadre " +
            "and up.usuario.nombreUsuario =:username order by m.orden")
    List<Menu> findRecursiveHijoByMenuPadreAndUsername(@Param("menuPadre") Integer menuPadre, @Param("username") String username);

    @Query("select m from Menu m " +
            "join Autorizacion  a on  m.idMenu=a.idMenu.idMenu " +
            "join PerfilUsuario up on a.idPerfil.idPerfil = up.perfilUsuarioPK.idPerfil " +
            "where m.activo = 'SI' and m.idMenuPadre.idMenu= null " +
            "and up.usuario.nombreUsuario =:username order by m.orden")
    List<Menu> findMenuRaizByUsername(@Param("username") String username);


    @Query("select m.idMenuPadre from Menu m where m.idMenu = ?1")
    Menu findMenuPadreByIdMenu(int idMenu);
}
