package br.com.w4solution.lanches.dto;

import br.com.w4solution.lanches.domain.item.Categoria;
import br.com.w4solution.lanches.domain.item.Item;

public record ItemDto(Long id, String nome, String descricao, Double valor, Categoria categoria, String imagem) {
    public ItemDto(Item item){
        this(item.getId(), item.getNome(), item.getDescricao(), item.getValor(), item.getCategoria(), item.getImagemPath());
    }
}
