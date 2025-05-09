package br.com.w4solution.lanches.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticao(@NotBlank String usuario, @NotBlank String senha) {
}
