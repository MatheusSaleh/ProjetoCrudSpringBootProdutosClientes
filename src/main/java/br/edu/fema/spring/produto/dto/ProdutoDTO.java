package br.edu.fema.spring.produto.dto;

import br.edu.fema.spring.categoria.dto.CategoriaDTO;
import br.edu.fema.spring.produto.model.Produto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProdutoDTO {
    private Long id;
    private String nome;
    private Float valor;
    private CategoriaDTO categoriaDTO;

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
        this.categoriaDTO = new CategoriaDTO(produto.getCategoria());
    }

    public static List<ProdutoDTO> converter(List<Produto> produtos){
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }
}
