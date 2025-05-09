package br.com.w4solution.lanches.dto;

import br.com.w4solution.lanches.domain.pedido.StatusPedido;

public record AtualizarPedidoDto(StatusPedido status) {
}
