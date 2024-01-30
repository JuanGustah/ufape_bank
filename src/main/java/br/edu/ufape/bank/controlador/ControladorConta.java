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

import br.edu.ufape.bank.controlador.dto.RequisicaoDebitarCreditar;
import br.edu.ufape.bank.controlador.dto.RequisicaoTransferirValorConta;
import br.edu.ufape.bank.fachada.Banco;
import br.edu.ufape.bank.negocio.entidade.Conta;
import br.edu.ufape.bank.negocio.entidade.ContaAbstrata;
import br.edu.ufape.bank.negocio.excecao.cliente.ClienteNaoEncontradoException;
import br.edu.ufape.bank.negocio.excecao.conta.ContaNaoEncontradaException;
import br.edu.ufape.bank.negocio.excecao.conta.SaldoInsuficienteException;
import br.edu.ufape.bank.negocio.excecao.conta.TipoContaNaoExisteException;

@Controller
public class ControladorConta {
	@Autowired
	private Banco banco;
	
	@GetMapping(value = "/conta")
	public ResponseEntity<List<ContaAbstrata>> listarConta() {
		return ResponseEntity.ok(banco.listarConta());
	}
	
	@GetMapping(value = "/conta/{idConta}")
	public ResponseEntity<?> visualizarConta(@PathVariable long idConta) {
		try {
			return ResponseEntity.ok(banco.consultarConta(idConta));
		} catch (ContaNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping(value = "/conta/{tipoConta}")
	public ResponseEntity<String> cadastrarConta(@RequestBody Conta conta, @PathVariable int tipoConta) {
		try {
			banco.adicionarConta(conta, tipoConta);
			return ResponseEntity.ok("Cadastrada com sucesso!");
		} catch (TipoContaNaoExisteException | ClienteNaoEncontradoException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PatchMapping(value = "/conta/{idConta}")
	public ResponseEntity<String> atualizarConta(@PathVariable long idConta, @RequestBody Conta conta) {
		try {
			banco.atualizarConta(idConta,conta.getCliente().getId(),conta.getNumero());
			return ResponseEntity.ok("Atualizado com sucesso!");
		} catch (ClienteNaoEncontradoException | ContaNaoEncontradaException e) {
			return ResponseEntity.badRequest().body("Conta não foi encontrada.");
		}
	}
	
	@DeleteMapping(value = "/conta/{idConta}")
	public ResponseEntity<String> removerConta(@PathVariable long idConta) {
		try {
			banco.removerConta(idConta);
			return ResponseEntity.ok("Conta removida com sucesso!");
		} catch (ContaNaoEncontradaException e) {
			return ResponseEntity.badRequest().body("Conta não foi encontrada.");
		}
	}
	
	@PostMapping(value = "/conta/transferir")
	public ResponseEntity<String> transferir(@RequestBody RequisicaoTransferirValorConta requisicaoTransferirValorConta) {
		try {
			banco.transferir(requisicaoTransferirValorConta.getIdContaOrigem(),requisicaoTransferirValorConta.getIdContaDestino(),requisicaoTransferirValorConta.getValor());
			return ResponseEntity.ok("Transferência realizada com sucesso!");
		} catch (SaldoInsuficienteException | ContaNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping(value = "/conta/debitar")
	public ResponseEntity<String> debitar(@RequestBody RequisicaoDebitarCreditar requisicaoDebitarCreditar) {
		try {
			banco.debitar(requisicaoDebitarCreditar.getIdConta(),requisicaoDebitarCreditar.getValor());
			return ResponseEntity.ok("Débito realizado com sucesso!");
		} catch (SaldoInsuficienteException | ContaNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping(value = "/conta/creditar")
	public ResponseEntity<String> creditar(@RequestBody RequisicaoDebitarCreditar requisicaoDebitarCreditar) {
		try {
			banco.creditar(requisicaoDebitarCreditar.getIdConta(),requisicaoDebitarCreditar.getValor());
			return ResponseEntity.ok("Crédito realizado com sucesso!");
		} catch (ContaNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
}
