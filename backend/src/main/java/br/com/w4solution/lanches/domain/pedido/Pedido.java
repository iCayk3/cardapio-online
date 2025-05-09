package br.com.w4solution.lanches.domain.pedido;

import br.com.w4solution.lanches.domain.item.Item;
import br.com.w4solution.lanches.dto.AtualizarPedidoDto;
import br.com.w4solution.lanches.dto.CadastrarPedidoDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pedidos")
@EqualsAndHashCode(of = "id")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<Item> itens;
    private Double valor;
    @Enumerated(EnumType.STRING)
    private StatusPedido status = StatusPedido.PEDENTE;
    private Integer numeroMesa;

    public Pedido(CadastrarPedidoDto dados, List<Item> itens) {
        this.itens = itens;
        this.valor = somaTotalDoValor(itens);
        this.numeroMesa = dados.numeroMesa();
    }

    private Double somaTotalDoValor(List<Item> itens) {
        return itens.stream()
                .mapToDouble(i -> i.getValor() * i.getQuantidade())
                .sum();
    }

    public void atualizarStatusPedido(AtualizarPedidoDto dados) {
        this.status = dados.status();
    }
}
