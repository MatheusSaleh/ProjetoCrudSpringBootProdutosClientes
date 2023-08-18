package br.edu.fema.spring.cliente.resource;

import br.edu.fema.spring.cliente.dto.ClienteDTO;
import br.edu.fema.spring.cliente.form.ClienteForm;
import br.edu.fema.spring.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/clientes")
@RestController
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes(){
        return this.clienteService.listarClientes();
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<ClienteDTO> listarCliente(@PathVariable Long idCliente){
        return this.clienteService.listarCliente(idCliente);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody ClienteForm formulario){
        return this.clienteService.cadastrarCliente(formulario);
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long idCliente, @RequestBody ClienteForm formulario){
        return this.clienteService.atualizarCliente(idCliente, formulario);
    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<ClienteDTO> deletarCliente(@PathVariable Long idCliente){
        return this.clienteService.deletarCategoria(idCliente);
    }

    @GetMapping("/clientes_pela_letra/{primeiraLetra}")
    public ResponseEntity<List<ClienteDTO>> listarClientesPelaPrimeiraLetra(@PathVariable String primeiraLetra){
        return this.clienteService.listarClientesPelaPrimeiraLetra(primeiraLetra.toUpperCase());
    }
}
