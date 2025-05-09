package br.com.w4solution.lanches.dto;

import java.util.List;

public record CadastrarPedidoDto(List<ItemPedidoDto> itens, Integer numeroMesa) {
}
