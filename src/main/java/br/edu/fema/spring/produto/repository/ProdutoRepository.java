package br.edu.fema.spring.produto.repository;

import br.edu.fema.spring.produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByCategoria_Id(Long idCategoria);

    void deleteByCategoria_Id(Long idCategoria);

     
}
