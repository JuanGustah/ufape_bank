package br.edu.ufape.bank.negocio.entidade;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.Test;

import br.edu.ufape.bank.negocio.excecao.conta.SaldoInsuficienteException;

public class TesteConta {
//	@Test
//	void criarContaMesmoCliente(){
//		Cliente cliente = new Cliente();
//		
//		try {
//			Conta c1 = new Conta(cliente, "1647987", 0);
//			Conta c2 = new Conta(cliente, "4789", 0);
//			fail("Não deve ser possível adicionar duas contas com o mesmo cliente.");
//		}catch(Exception e) {
//			withSuccess();
//		}
//	}
	
	@Test
	void creditarComValorNegativo(){
		try {
			Conta c1 = new Conta();
			c1.creditar(-10);
			fail("Não deve ser possível creditar com valor negativo.");
		}catch(IllegalArgumentException e) {
			withSuccess();
		}
	}
	
	@Test
	void debitarEmContaSemSaldo(){
		try {
			Conta c1 = new Conta();
			c1.debitar(1000);
			fail("Não deve ser possível debitar valor em uma conta sem saldo.");
		}catch(SaldoInsuficienteException e) {
			withSuccess();
		}
	}
}
