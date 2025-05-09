package br.com.w4solution.lanches.service;

import br.com.w4solution.lanches.domain.pedido.Pedido;
import br.com.w4solution.lanches.domain.pedido.StatusPedido;
import br.com.w4solution.lanches.dto.AtualizarPedidoDto;
import br.com.w4solution.lanches.dto.CadastrarPedidoDto;
import br.com.w4solution.lanches.repository.ItemRepository;
import br.com.w4solution.lanches.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;
    @Autowired
    ItemRepository itemRepository;

    public Pedido cadastrarPedido(CadastrarPedidoDto dados){

        var itens = dados.itens().stream().map(i -> {
            var item = itemRepository.findById(i.id()).get();
            item.setQuantidade(i.quantidade());
            return item;
        }).toList();

        var pedido = new Pedido(dados, itens);
        repository.save(pedido);
        return pedido;
    }

    public List<Pedido> listarPedidos(StatusPedido status) {
        if(status != null){
            return repository.findAllByStatus(status);
        }
        return repository.findAll();
    }

    public void atualizarPedido(Long id, AtualizarPedidoDto dados) {
        var pedido = repository.findById(id);
        pedido.ifPresent(value -> value.atualizarStatusPedido(dados));
    }

    public void deletarPedido(Long id) {
        repository.deleteById(id);
    }
}
