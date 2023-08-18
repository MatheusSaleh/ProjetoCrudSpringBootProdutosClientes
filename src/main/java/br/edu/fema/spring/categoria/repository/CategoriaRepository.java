package br.edu.fema.spring.categoria.repository;

import br.edu.fema.spring.categoria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
