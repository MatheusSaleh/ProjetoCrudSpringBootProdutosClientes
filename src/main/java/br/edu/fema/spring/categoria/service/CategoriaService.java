package br.edu.fema.spring.categoria.service;

import br.edu.fema.spring.categoria.dto.CategoriaDTO;
import br.edu.fema.spring.categoria.form.CategoriaForm;
import br.edu.fema.spring.categoria.model.Categoria;
import br.edu.fema.spring.categoria.repository.CategoriaRepository;
import br.edu.fema.spring.exception.handler.ObjetoNaoEncontradoException;
import br.edu.fema.spring.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return ResponseEntity.ok(CategoriaDTO.converter(categorias));
    }

    public ResponseEntity<CategoriaDTO> listarCategoria(Long idCategoria){
        Categoria categoria = this.buscarCategoria(idCategoria);
        return ResponseEntity.ok(new CategoriaDTO(categoria));
    }

    public ResponseEntity<CategoriaDTO> cadastrarCategoria(CategoriaForm formulario){
        Categoria categoria = new Categoria();
        categoria.setNome(formulario.getNome());
        categoria = categoriaRepository.save(categoria);
        return ResponseEntity.ok(new CategoriaDTO(categoria));
    }

    @Transactional
    public ResponseEntity<CategoriaDTO> atualizarCategoria(Long idCategoria, CategoriaForm formulario){
        Categoria categoria = this.buscarCategoria(idCategoria);
        categoria.setNome(formulario.getNome());
        return ResponseEntity.ok(new CategoriaDTO(categoria));
    }

    @Transactional
    public ResponseEntity<CategoriaDTO> deletarCategoria(Long idCategoria){
        Categoria categoria = buscarCategoria(idCategoria);
        this.categoriaRepository.deleteById(categoria.getId());
        return ResponseEntity.ok().build();
    }

    @Transactional
    public Categoria buscarCategoria(Long idCategoria){
        Optional<Categoria> optionalCategoria = this.categoriaRepository.findById(idCategoria);
        if(!optionalCategoria.isPresent()){
            throw new ObjetoNaoEncontradoException("Categoria com id " +idCategoria+" não encontrado!");
        }
        return optionalCategoria.get();
    }
}
