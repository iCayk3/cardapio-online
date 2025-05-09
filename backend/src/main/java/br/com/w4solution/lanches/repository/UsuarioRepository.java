package br.com.w4solution.lanches.repository;

import br.com.w4solution.lanches.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Boolean existsByUsuario(String usuario);

    UserDetails findByUsuario(String subject);
}
