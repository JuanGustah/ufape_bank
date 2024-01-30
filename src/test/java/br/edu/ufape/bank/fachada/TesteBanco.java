package br.edu.ufape.bank.fachada;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ufape.bank.negocio.entidade.Cliente;
import br.edu.ufape.bank.negocio.entidade.Conta;

public class TesteBanco {
	@Autowired
	Banco banco;
	
//	@Test
//	void criarContaMesmoCliente(){
//		Cliente cliente = new Cliente();
//		
//		try {
//			banco.adicionarConta(cliente.getId(), "5489745", 0, 1);
//			banco.adicionarConta(cliente.getId(), "4198789", 0, 1);
//			fail("Não deve ser possível adicionar duas contas com o mesmo cliente.");
//		}catch(Exception e) {
//			withSuccess();
//		}
//	}
//	
	@Test
	void transferirValorEntreContasSemSaldo(){
		Conta conta = new Conta();
		Conta conta2 = new Conta();
		
		try {
			banco.transferir(conta.getId(), conta2.getId(), 1000);
			fail("Não deve ser possível adicionar duas contas com o mesmo cliente.");
		}catch(Exception e) {
			withSuccess();
		}
	}
}
