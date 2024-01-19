package br.edu.ufape.bank.negocio.entidade;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.Test;

import br.edu.ufape.bank.negocio.excecao.conta.SaldoInsuficienteException;

public class TesteContaImposto {
	@Test
	void creditarComValorNegativo(){
		try {
			ContaImposto c1 = new ContaImposto();
			c1.creditar(-10);
			fail("Não deve ser possível creditar com valor negativo.");
		}catch(IllegalArgumentException e) {
			withSuccess();
		}
	}
	
	@Test
	void debitarEmContaSemSaldo(){
		try {
			ContaImposto c1 = new ContaImposto();
			c1.debitar(1000);
			fail("Não deve ser possível debitar valor em uma conta sem saldo.");
		}catch(SaldoInsuficienteException e) {
			withSuccess();
		}
	}
}
