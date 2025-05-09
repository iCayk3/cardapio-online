package br.com.w4solution.lanches.domain.item;


import br.com.w4solution.lanches.domain.pedido.Pedido;
import br.com.w4solution.lanches.dto.CadastrarItemDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "itens")
@EqualsAndHashCode(of = "id")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double valor;
    @Transient
    private Integer quantidade;
    private String imagemPath;
    @ManyToMany
    private List<Pedido> pedidos;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Item(CadastrarItemDto dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.valor = dados.valor();
        this.categoria = dados.categoria();
    }
}
