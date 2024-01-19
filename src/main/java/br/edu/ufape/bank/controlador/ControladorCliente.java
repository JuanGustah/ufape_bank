package br.edu.ufape.bank.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.ufape.bank.fachada.Banco;
import br.edu.ufape.bank.negocio.entidade.Cliente;
import br.edu.ufape.bank.negocio.excecao.cliente.ClienteNaoEncontradoException;

@Controller
public class ControladorCliente {
	@Autowired
	private Banco banco;
	
	@GetMapping(value = "/cliente")
	public ResponseEntity<List<Cliente>> listarCliente() {
		return ResponseEntity.ok(banco.listarCliente());
	}
	
	@GetMapping(value = "/cliente/{idCliente}")
	public ResponseEntity<?> visualizarCliente(@PathVariable long idCliente) {
		try {
			return ResponseEntity.ok(banco.consultarCliente(idCliente));
		} catch (ClienteNaoEncontradoException e) {
			return ResponseEntity.badRequest().body("Cliente não foi encontrado.");
		}
	}
	
	@PostMapping(value = "/cliente")
	public ResponseEntity<String> cadastrarCliente(@RequestBody Cliente cliente) {
		banco.adicionarCliente(cliente);
		return ResponseEntity.ok("Cadastrado com sucesso!");
	}
	
	@PatchMapping(value = "/cliente/{idCliente}")
	public ResponseEntity<String> atualizarCliente(@PathVariable long idCliente, @RequestBody Cliente cliente) {
		try {
			banco.atualizarCliente(idCliente,cliente);
			return ResponseEntity.ok("Atualizado com sucesso!");
		} catch (ClienteNaoEncontradoException e) {
			return ResponseEntity.badRequest().body("Cliente não foi encontrado.");
		}
	}
	
	@DeleteMapping(value = "/cliente/{idCliente}")
	public ResponseEntity<String> removerCliente(@PathVariable long idCliente) {
		try {
			banco.removerCliente(idCliente);
			return ResponseEntity.ok("Cliente removido com sucesso!");
		} catch (ClienteNaoEncontradoException e) {
			return ResponseEntity.badRequest().body("Cliente não foi encontrado.");
		}
	}
}
