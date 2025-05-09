package br.com.w4solution.lanches.dto;

import jakarta.validation.constraints.NotBlank;

public record CadastrarUsuarioDto(@NotBlank String usuario, @NotBlank String senha, String nome, String cpf, String email) {
}