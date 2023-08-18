package br.edu.fema.spring.categoria.resource;

import br.edu.fema.spring.categoria.dto.CategoriaDTO;
import br.edu.fema.spring.categoria.form.CategoriaForm;
import br.edu.fema.spring.categoria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/categoria")
@RestController
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listarCategorias(){
        return this.categoriaService.listarCategorias();
    }

    @GetMapping("/{idCategoria}")
    public ResponseEntity<CategoriaDTO> listarCategoria(@PathVariable Long idCategoria){
        return this.categoriaService.listarCategoria(idCategoria);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> cadastrarCategoria(@RequestBody CategoriaForm formulario){
        return this.categoriaService.cadastrarCategoria(formulario);
    }

    @PutMapping("/{idCategoria}")
    public ResponseEntity<CategoriaDTO> atualizarCategoria(@PathVariable Long idCategoria, @RequestBody CategoriaForm formulario){
        return this.categoriaService.atualizarCategoria(idCategoria, formulario);
    }

    @DeleteMapping("/{idCategoria}")
    public ResponseEntity<CategoriaDTO> deletarCategoria(@PathVariable Long idCategoria){
        return this.categoriaService.deletarCategoria(idCategoria);
    }
}
