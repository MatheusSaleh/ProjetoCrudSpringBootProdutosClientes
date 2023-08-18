package br.edu.fema.spring.cliente.repository;

import br.edu.fema.spring.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeStartingWith(String letra);
}
