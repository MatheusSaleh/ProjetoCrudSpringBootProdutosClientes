package br.edu.fema.spring.produto.resource;

import br.edu.fema.spring.produto.dto.ProdutoDTO;
import br.edu.fema.spring.produto.form.ProdutoForm;
import br.edu.fema.spring.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/produtos")
@RestController
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos(){
        return this.produtoService.listarProdutos();
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<ProdutoDTO> listarProduto(@PathVariable Long idProduto){
        return this.produtoService.listarProduto(idProduto);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastrarProduto(@Valid @RequestBody ProdutoForm formulario){
        return this.produtoService.cadastrarProduto(formulario);
    }

    @PutMapping("/{idProduto}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long idProduto, @RequestBody ProdutoForm formulario){
        return this.produtoService.atualizarProduto(idProduto, formulario);
    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<ProdutoDTO> deletarProduto(@PathVariable Long idProduto){
        return this.produtoService.deletarProduto(idProduto);
    }


    @DeleteMapping("/produtos_categoria/{idCategoria}")
    public ResponseEntity<List<ProdutoDTO>> deletarProdutosPeloIdDaCategoria(@PathVariable Long idCategoria){
        return this.produtoService.deletarProdutosPeloIdDaCategoria(idCategoria);
    }

    @GetMapping("/produtos_categoria/{idCategoria}")
    public ResponseEntity<List<ProdutoDTO>> listarProdutosPeloIdDaCategoria(@PathVariable Long idCategoria){
        return this.produtoService.listarProdutosPeloIdDaCategoria(idCategoria);
    }
}
