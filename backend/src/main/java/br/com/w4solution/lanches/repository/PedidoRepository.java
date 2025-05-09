package br.com.w4solution.lanches.repository;

import br.com.w4solution.lanches.domain.pedido.Pedido;
import br.com.w4solution.lanches.domain.pedido.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findAllByStatus(StatusPedido status);
}
