package br.edu.ufape.bank.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.bank.negocio.IColecaoClientes;
import br.edu.ufape.bank.negocio.IColecaoContas;
import br.edu.ufape.bank.negocio.entidade.Cliente;
import br.edu.ufape.bank.negocio.entidade.Conta;
import br.edu.ufape.bank.negocio.entidade.ContaAbstrata;
import br.edu.ufape.bank.negocio.entidade.ContaBonificada;
import br.edu.ufape.bank.negocio.entidade.ContaImposto;
import br.edu.ufape.bank.negocio.entidade.ContaPoupanca;
import br.edu.ufape.bank.negocio.excecao.cliente.ClienteNaoEncontradoException;
import br.edu.ufape.bank.negocio.excecao.conta.ContaNaoEncontradaException;
import br.edu.ufape.bank.negocio.excecao.conta.SaldoInsuficienteException;
import br.edu.ufape.bank.negocio.excecao.conta.TipoContaNaoExisteException;

@Service
public class Banco {
	@Autowired
	private IColecaoClientes cadastroCliente;
	@Autowired
	private IColecaoContas cadastroConta;
	
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
    public void adicionarConta(long idCliente, String numeroConta, double saldo, int tipo) throws TipoContaNaoExisteException, ClienteNaoEncontradoException{
    	Cliente cliente = cadastroCliente.consultar(idCliente);
    	ContaAbstrata conta;
    	
    	switch(tipo) {
	    	case 1: // Tipo Conta
	            conta = new Conta(cliente, numeroConta, saldo);
	            break;
	        case 2: // Tipo Poupanca
	            conta = new ContaPoupanca(cliente, numeroConta, saldo);
	            break;
	        case 3: // Tipo ContaBonificada
	            conta = new ContaBonificada(cliente, numeroConta, saldo);
	            break;
	        case 4: // Tipo ContaImposto
	            conta = new ContaImposto(cliente, numeroConta, saldo);
	            break;
	        default:
	            throw new TipoContaNaoExisteException();
    	}
    	
    	cadastroConta.adicionar(conta);
    }

    public void removerConta(long id) throws ContaNaoEncontradaException{
    	cadastroConta.remover(id);
    }

    public void atualizarConta(long id, long idCliente, String numero) throws ContaNaoEncontradaException, ClienteNaoEncontradoException{
    	Cliente cliente = cadastroCliente.consultar(idCliente);
    	
    	cadastroConta.atualizar(id, cliente, numero);
    }
    
    public ContaAbstrata consultarConta(long id) throws ContaNaoEncontradaException{
    	return cadastroConta.consultar(id);
    }

    public List<ContaAbstrata> listarConta(){
    	return cadastroConta.listar();
    }
    
    public void transferir(long idContaOrigem, long idContaDestino, double valor) throws SaldoInsuficienteException, ContaNaoEncontradaException {
    	cadastroConta.transferir(idContaOrigem, idContaDestino, valor);
    }
    
    public void debitar(long idConta, double valor) throws ContaNaoEncontradaException, SaldoInsuficienteException {
    	cadastroConta.debitar(idConta, valor);
    }
    
    public void creditar(long idConta, double valor) throws ContaNaoEncontradaException {
    	cadastroConta.creditar(idConta, valor);
    }
    
}
