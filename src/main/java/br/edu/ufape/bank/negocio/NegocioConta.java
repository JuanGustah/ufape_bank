package br.edu.ufape.bank.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.bank.dados.IColecaoConta;
import br.edu.ufape.bank.dados.IRepositorioContas;
import br.edu.ufape.bank.negocio.entidade.Cliente;
import br.edu.ufape.bank.negocio.entidade.ContaAbstrata;
import br.edu.ufape.bank.negocio.excecao.conta.ContaNaoEncontradaException;

@Service
public class NegocioConta implements IRepositorioContas{
	@Autowired
	private IColecaoConta colecaoConta;

	@Override
	public void adicionar(ContaAbstrata conta) {
		colecaoConta.save(conta);
	}

	@Override
	public void remover(long id) throws ContaNaoEncontradaException{
		ContaAbstrata conta = colecaoConta.findById(id).orElse(null);
		
		if(conta == null) {
			throw new ContaNaoEncontradaException();
		}
		
		colecaoConta.deleteById(id);
	}

	@Override
	public void atualizar(long id, ContaAbstrata conta) throws ContaNaoEncontradaException{
		ContaAbstrata contaSalva = colecaoConta.findById(id).orElse(null);
		
		if(contaSalva == null) {
			throw new ContaNaoEncontradaException();
		}
		
		contaSalva.setCliente(conta.getCliente());
		contaSalva.setNumero(conta.getNumero());
		
		colecaoConta.save(contaSalva);
	}

	@Override
	public boolean existe(String numero) {
		ContaAbstrata conta = colecaoConta.findByNumero(numero);
		
		if(conta == null) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean existe(long id) {
		ContaAbstrata conta = colecaoConta.findById(id).orElse(null);
		
		if(conta == null) {
			return false;
		}
		
		return true;
	}

	@Override
	public ContaAbstrata consultar(String numero) throws ContaNaoEncontradaException{
		ContaAbstrata conta = colecaoConta.findByNumero(numero);
		
		if(conta == null) {
			throw new ContaNaoEncontradaException();
		}
		
		return conta;
	}

	@Override
	public ContaAbstrata consultar(long id) throws ContaNaoEncontradaException {
		ContaAbstrata conta = colecaoConta.findById(id).orElse(null);
		
		if(conta == null) {
			throw new ContaNaoEncontradaException();
		}
		
		return conta;
	}

	@Override
	public List<ContaAbstrata> listar() {
		return colecaoConta.findAll();
	}

	@Override
	public List<ContaAbstrata> consultar(Cliente cliente) {
		List<ContaAbstrata> contas = colecaoConta.findByClienteId(cliente.getId());
		
		return contas;
	}
}
