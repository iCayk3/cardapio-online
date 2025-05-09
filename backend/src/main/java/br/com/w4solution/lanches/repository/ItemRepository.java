package br.com.w4solution.lanches.repository;

import br.com.w4solution.lanches.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
