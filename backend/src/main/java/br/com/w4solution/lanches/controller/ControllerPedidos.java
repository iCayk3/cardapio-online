package br.com.w4solution.lanches.controller;

import br.com.w4solution.lanches.domain.pedido.StatusPedido;
import br.com.w4solution.lanches.dto.AtualizarPedidoDto;
import br.com.w4solution.lanches.dto.CadastrarPedidoDto;
import br.com.w4solution.lanches.dto.PedidoDto;
import br.com.w4solution.lanches.service.PedidoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("pedidos")
public class ControllerPedidos {

    @Autowired
    PedidoService service;

    @GetMapping
    public ResponseEntity<List<PedidoDto>> listarPedidos(@RequestParam(required = false) StatusPedido status){
        var pedidos = service.listarPedidos(status).stream().map(PedidoDto::new).toList();
        return ResponseEntity.ok().body(pedidos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PedidoDto> cadastrarPedido(@RequestBody CadastrarPedidoDto dados, UriComponentsBuilder uri){
        var pedido = service.cadastrarPedido(dados);
        var uriCreate = uri.path("/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uriCreate).body(new PedidoDto(pedido));
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarPedido(@PathVariable Long id, @RequestBody AtualizarPedidoDto dados){
        service.atualizarPedido(id, dados);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarPedido(@PathVariable Long id){
        service.deletarPedido(id);
        return ResponseEntity.ok().build();
    }
}
