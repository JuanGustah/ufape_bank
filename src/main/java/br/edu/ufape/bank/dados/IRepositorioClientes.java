package br.edu.ufape.bank.dados;

import br.edu.ufape.bank.negocio.entidade.Cliente;

public interface IRepositorioClientes {
	void adicionar(Cliente cliente);

    void remover(Cliente cliente);

    void atualizar(Cliente cliente);

    Cliente consultar(Cliente cliente);

    Cliente consultar(String cpf);
    
    Cliente consultar(long id);

    void listar();

    boolean existe(String cpf);
    
    boolean existe(long id);
}
