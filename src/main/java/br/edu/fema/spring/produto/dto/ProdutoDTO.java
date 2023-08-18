package br.edu.fema.spring.produto.dto;

import br.edu.fema.spring.categoria.dto.CategoriaDTO;
import br.edu.fema.spring.categoria.model.Categoria;
import br.edu.fema.spring.produto.model.Produto;

import java.util.List;
import java.util.stream.Collectors;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public CategoriaDTO getCategoriaDTO() {
        return categoriaDTO;
    }

    public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
        this.categoriaDTO = categoriaDTO;
    }

    public static List<ProdutoDTO> converter(List<Produto> produtos){
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }
}
