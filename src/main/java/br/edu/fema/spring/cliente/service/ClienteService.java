package br.edu.fema.spring.cliente.service;

import br.edu.fema.spring.cliente.dto.ClienteDTO;
import br.edu.fema.spring.cliente.form.ClienteForm;
import br.edu.fema.spring.cliente.model.Cliente;
import br.edu.fema.spring.cliente.repository.ClienteRepository;
import br.edu.fema.spring.exception.handler.ObjetoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public ResponseEntity<List<ClienteDTO>> listarClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(ClienteDTO.converter(clientes));
    }

    public ResponseEntity<ClienteDTO> listarCliente(Long idCliente){
        Cliente cliente = this.buscarCliente(idCliente);
        return ResponseEntity.ok(new ClienteDTO(cliente));
    }

    public ResponseEntity<ClienteDTO> cadastrarCliente(ClienteForm formulario){
        Cliente cliente = new Cliente();
        cliente.setNome(formulario.getNome());
        cliente.setCpf(formulario.getCpf());
        cliente.setRg(formulario.getRg());
        cliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(new ClienteDTO(cliente));
    }

    @Transactional
    public ResponseEntity<ClienteDTO> atualizarCliente(Long idCliente, ClienteForm formulario){
        Cliente cliente = this.buscarCliente(idCliente);
        cliente.setNome(formulario.getNome());
        cliente.setCpf(formulario.getCpf());
        cliente.setRg(formulario.getRg());
        return ResponseEntity.ok(new ClienteDTO(cliente));
    }
    @Transactional
    public ResponseEntity<ClienteDTO> deletarCategoria(Long idCliente) {
        Cliente cliente = buscarCliente(idCliente);
        this.clienteRepository.deleteById(cliente.getId());
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<ClienteDTO>> listarClientesPelaPrimeiraLetra(String letra){
        List<Cliente> clientes = this.clienteRepository.findByNomeStartingWith(letra);
        return ResponseEntity.ok(ClienteDTO.converter(clientes));
    }

    public Cliente buscarCliente(Long idCliente){
        Optional<Cliente> optionalCliente = this.clienteRepository.findById(idCliente);
        if(optionalCliente.isEmpty()){
            throw new ObjetoNaoEncontradoException("Cliente com id "+idCliente+" não encontrado");
        }
        return optionalCliente.get();
    }
}
