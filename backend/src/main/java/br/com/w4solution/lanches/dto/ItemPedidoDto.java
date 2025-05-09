package br.com.w4solution.lanches.dto;

import br.com.w4solution.lanches.domain.item.Item;

public record ItemPedidoDto(Long id, String nome, String descricao, Double valor, Integer quantidade) {
    public ItemPedidoDto(Item item){
        this(item.getId(), item.getNome(), item.getDescricao(), item.getValor(), item.getQuantidade());
    }
}
