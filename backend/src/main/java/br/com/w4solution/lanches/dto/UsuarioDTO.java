package br.com.w4solution.lanches.dto;

import br.com.w4solution.lanches.domain.usuario.Usuario;

public record UsuarioDTO(String usuario) {
    public UsuarioDTO(Usuario usuario){
        this(usuario.getUsuario());
    }
}
