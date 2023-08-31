package com.ec.cluv.academy.repository.publick;


import com.ec.cluv.academy.model.entities.publick.RefreshToken;
import com.ec.cluv.academy.model.entities.publick.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
  Optional<RefreshToken> findByToken(String token);

  @Modifying
  int deleteByUser(Usuario user);
}
