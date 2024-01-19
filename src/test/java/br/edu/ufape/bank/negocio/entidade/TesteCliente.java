package br.edu.ufape.bank.negocio.entidade;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.Test;

public class TesteCliente {

	@Test
	void criarClienteSemEndereco(){
		Cliente cliente = new Cliente();
		withSuccess();
	}
	
	@Test
	void criarClienteComEndereco(){
		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco("11111-111","1A","Centro");
		cliente.setEndereco(endereco);
		withSuccess();
	}
}
