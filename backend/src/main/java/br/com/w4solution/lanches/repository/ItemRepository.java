package br.com.w4solution.lanches.repository;

import br.com.w4solution.lanches.domain.item.Categoria;
import br.com.w4solution.lanches.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByCategoria(Categoria filtro);
}
