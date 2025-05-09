package br.com.w4solution.lanches.controller;

import br.com.w4solution.lanches.domain.item.Item;
import br.com.w4solution.lanches.dto.CadastrarItemDto;
import br.com.w4solution.lanches.dto.ItemDto;
import br.com.w4solution.lanches.service.ItemService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("item")
public class ControllerItem {

    @Autowired
    ItemService serivce;

    @GetMapping
    public ResponseEntity<List<ItemDto>> listarItem(){
        var itens = serivce.listarItens().stream().map(ItemDto::new).toList();
        return ResponseEntity.ok().body(itens);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ItemDto> cadastrarItem(@ModelAttribute @Valid CadastrarItemDto dados, UriComponentsBuilder uri){
        var item = serivce.cadastrarItem(dados);
        var uriCreate = uri.path("/item/{id}").buildAndExpand(item.getId()).toUri();
        return ResponseEntity.created(uriCreate).body(new ItemDto(item));
    }
}
