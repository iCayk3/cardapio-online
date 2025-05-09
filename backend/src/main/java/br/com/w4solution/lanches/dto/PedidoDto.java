package br.com.w4solution.lanches.dto;

import br.com.w4solution.lanches.domain.pedido.Pedido;
import br.com.w4solution.lanches.domain.pedido.StatusPedido;

import java.util.List;

public record PedidoDto(Long id, List<ItemPedidoDto> itens, Double valor, StatusPedido status, Integer numeroMesa) {
    public PedidoDto(Pedido pedido){
        this(pedido.getId(),
                pedido.getItens().stream().map(ItemPedidoDto::new).toList(),
                pedido.getValor(),
                pedido.getStatus(),
                pedido.getNumeroMesa());
    }
}
