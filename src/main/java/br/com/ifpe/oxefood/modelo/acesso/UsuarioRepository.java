package br.com.ifpe.oxefood.modelo.acesso;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //select * from usuario where username = :username
    Optional<Usuario> findByUsername(String username);

}