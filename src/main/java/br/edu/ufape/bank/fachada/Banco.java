package br.edu.ufape.bank.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.bank.dados.IRepositorioClientes;
import br.edu.ufape.bank.dados.IRepositorioContas;
import br.edu.ufape.bank.negocio.entidade.Cliente;
import br.edu.ufape.bank.negocio.entidade.ContaAbstrata;
import br.edu.ufape.bank.negocio.excecao.cliente.ClienteNaoEncontradoException;
import br.edu.ufape.bank.negocio.excecao.conta.ContaNaoEncontradaException;

@Service
public class Banco {
	@Autowired
	private IRepositorioClientes cadastroCliente;
	@Autowired
	private IRepositorioContas cadastroConta;
	
	/* Cliente */
	public void adicionarCliente(Cliente cliente) {
		cadastroCliente.adicionar(cliente);
	}
	
	public void removerCliente(long id) throws ClienteNaoEncontradoException{
		cadastroCliente.remover(id);
	}
	
	public void atualizarCliente(long id, Cliente cliente) throws ClienteNaoEncontradoException{
		cadastroCliente.atualizar(id, cliente);
	}
	
	public Cliente consultarCliente(String cpf) throws ClienteNaoEncontradoException{
		return cadastroCliente.consultar(cpf);
	}
    
    public Cliente consultarCliente(long id) throws ClienteNaoEncontradoException{
    	return cadastroCliente.consultar(id);
    }
    
    public List<Cliente> listarCliente(){
    	return cadastroCliente.listar();
    }

    public boolean existeCliente(String cpf) {
    	return cadastroCliente.existe(cpf);
    }
    
    public boolean existeCliente(long id) {
    	return cadastroCliente.existe(id);
    }
	
    /* Conta */
    public void adicionarConta(ContaAbstrata conta) {
    	cadastroConta.adicionar(conta);
    }

    public void removerConta(long id) throws ContaNaoEncontradaException{
    	cadastroConta.remover(id);
    }

    public void atualizarConta(long id, ContaAbstrata conta) throws ContaNaoEncontradaException{
    	cadastroConta.atualizar(id, conta);
    }

    public boolean existeConta(String numero) {
    	return cadastroConta.existe(numero);
    }
    
    public boolean existeConta(long id) {
    	return cadastroConta.existe(id);
    }

    public ContaAbstrata consultarConta(String numero) throws ContaNaoEncontradaException{
    	return cadastroConta.consultar(numero);
    }
    
    public ContaAbstrata consultarConta(long id) throws ContaNaoEncontradaException{
    	return cadastroConta.consultar(id);
    }

    public List<ContaAbstrata> consultarConta(Cliente cliente){
    	return cadastroConta.consultar(cliente);
    }

    public List<ContaAbstrata> listarConta(){
    	return cadastroConta.listar();
    }
}
