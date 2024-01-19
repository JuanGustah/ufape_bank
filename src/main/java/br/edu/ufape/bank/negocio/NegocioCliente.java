package br.edu.ufape.bank.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.bank.dados.IColecaoCliente;
import br.edu.ufape.bank.dados.IRepositorioClientes;
import br.edu.ufape.bank.negocio.entidade.Cliente;
import br.edu.ufape.bank.negocio.excecao.cliente.ClienteNaoEncontradoException;

@Service
public class NegocioCliente implements IRepositorioClientes{
	@Autowired
	 private IColecaoCliente colecaoCliente;

	@Override
	public void adicionar(Cliente cliente) {
		colecaoCliente.save(cliente);
	}

	@Override
	public void remover(long id) throws ClienteNaoEncontradoException{
		Cliente cliente = colecaoCliente.findById(id).orElse(null);
		
		if(cliente == null) {
			throw new ClienteNaoEncontradoException();
		}
		
		colecaoCliente.deleteById(id);
	}

	@Override
	public void atualizar(long id, Cliente cliente) throws ClienteNaoEncontradoException{
		Cliente clienteSalvo = colecaoCliente.findById(id).orElse(null);
		
		if(clienteSalvo == null) {
			throw new ClienteNaoEncontradoException();
		}
		
		clienteSalvo.setNome(cliente.getNome());
		clienteSalvo.setCpf(cliente.getCpf());
		clienteSalvo.setEndereco(cliente.getEndereco());
		
		colecaoCliente.save(clienteSalvo);
	}

	@Override
	public Cliente consultar(String cpf) throws ClienteNaoEncontradoException{
		Cliente cliente = colecaoCliente.findByCpf(cpf);
		
		if(cliente == null) {
			throw new ClienteNaoEncontradoException();
		}
		
		return cliente;
	}

	@Override
	public Cliente consultar(long id) throws ClienteNaoEncontradoException{
		Cliente cliente = colecaoCliente.findById(id).orElse(null);
		
		if(cliente == null) {
			throw new ClienteNaoEncontradoException();
		}
		
		return cliente;
	}

	@Override
	public List<Cliente> listar() {
		return colecaoCliente.findAll();
	}

	@Override
	public boolean existe(String cpf) {
		Cliente cliente = colecaoCliente.findByCpf(cpf);
		
		if(cliente == null)
			return false;
		
		return true;
	}

	@Override
	public boolean existe(long id) {
		Cliente cliente = colecaoCliente.findById(id).orElse(null);
		
		if(cliente == null)
			return false;
		
		return true;
	}
}
