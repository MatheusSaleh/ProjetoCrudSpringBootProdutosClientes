package br.edu.fema.spring.produto.service;

import br.edu.fema.spring.categoria.model.Categoria;
import br.edu.fema.spring.categoria.service.CategoriaService;
import br.edu.fema.spring.exception.handler.ObjetoNaoEncontradoException;
import br.edu.fema.spring.produto.dto.ProdutoDTO;
import br.edu.fema.spring.produto.form.ProdutoForm;
import br.edu.fema.spring.produto.model.Produto;
import br.edu.fema.spring.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaService categoriaService;

    public ResponseEntity<List<ProdutoDTO>> listarProdutos(){
        List<Produto> produtos = produtoRepository.findAll();
        return ResponseEntity.ok(ProdutoDTO.converter(produtos));
    }

    public ResponseEntity<ProdutoDTO> listarProduto(Long idProduto){
        Produto produto = this.buscarProduto(idProduto);
        return ResponseEntity.ok(new ProdutoDTO(produto));
    }

    public ResponseEntity<ProdutoDTO> cadastrarProduto(ProdutoForm formulario){
        Produto produto = new Produto();
        produto.setNome(formulario.getNome());
        produto.setValor(formulario.getValor());
        produto.setCategoria(formulario.getCategoria());
        produto = produtoRepository.save(produto);
        return ResponseEntity.ok(new ProdutoDTO(produto));
    }

    public ResponseEntity<ProdutoDTO> atualizarProduto(Long idProduto, ProdutoForm formulario){
        Produto produto = this.buscarProduto(idProduto);
        produto.setNome(formulario.getNome());
        produto.setValor(formulario.getValor());
        produto.setCategoria(formulario.getCategoria());
        return ResponseEntity.ok(new ProdutoDTO(produto));
    }

    public ResponseEntity<ProdutoDTO> deletarProduto(Long idProduto){
        Produto produto = buscarProduto(idProduto);
        this.produtoRepository.deleteById(produto.getId());
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<ProdutoDTO>> listarProdutosPeloIdDaCategoria(Long idCategoria){
        Categoria categoria = this.categoriaService.buscarCategoria(idCategoria);
        List<Produto> produtos = this.produtoRepository.findByCategoria_Id(categoria.getId());
        return ResponseEntity.ok(ProdutoDTO.converter(produtos));
    }

    @Transactional
    public ResponseEntity<List<ProdutoDTO>> deletarProdutosPeloIdDaCategoria(Long idCategoria) {
        Categoria categoria = this.categoriaService.buscarCategoria(idCategoria);
        this.produtoRepository.deleteByCategoria_Id(categoria.getId());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public Produto buscarProduto(Long idProduto){
        Optional<Produto> optionalProduto = this.produtoRepository.findById(idProduto);
        if(optionalProduto.isEmpty()){
            throw new ObjetoNaoEncontradoException("Produto com id "+idProduto+" não encontrado!");
        }
        return optionalProduto.get();
    }

}
