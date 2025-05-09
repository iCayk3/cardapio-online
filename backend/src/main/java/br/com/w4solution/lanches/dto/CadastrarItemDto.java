package br.com.w4solution.lanches.dto;

import br.com.w4solution.lanches.domain.item.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record CadastrarItemDto(@NotBlank String nome, String descricao, @NotNull Double valor, @NotNull Categoria categoria, MultipartFile imagem) {
}
