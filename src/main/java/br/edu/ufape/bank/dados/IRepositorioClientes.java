package br.edu.ufape.bank.dados;

import java.util.List;

import br.edu.ufape.bank.negocio.entidade.Cliente;
import br.edu.ufape.bank.negocio.excecao.conta.ClienteNaoEncontradoException;

public interface IRepositorioClientes {
	void adicionar(Cliente cliente);

    void remover(long id) throws ClienteNaoEncontradoException;

    void atualizar(Cliente cliente);

    Cliente consultar(String cpf) throws ClienteNaoEncontradoException;
    
    Cliente consultar(long id) throws ClienteNaoEncontradoException;

    List<Cliente> listar();

    boolean existe(String cpf);
    
    boolean existe(long id);
}
