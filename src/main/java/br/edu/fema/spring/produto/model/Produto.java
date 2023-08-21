package br.edu.fema.spring.produto.model;

import br.edu.fema.spring.categoria.model.Categoria;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "produto")
@Getter
@Setter

public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Column(name = "valor", precision = 10, scale = 2, nullable = false)
    private Float valor;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

}
