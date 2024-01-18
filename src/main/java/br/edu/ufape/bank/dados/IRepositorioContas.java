package br.edu.ufape.bank.dados;

import java.util.List;

import br.edu.ufape.bank.negocio.entidade.Cliente;
import br.edu.ufape.bank.negocio.entidade.ContaAbstrata;
import br.edu.ufape.bank.negocio.excecao.conta.ContaNaoEncontradaException;

public interface IRepositorioContas {

    void adicionar(ContaAbstrata conta);

    void remover(long id) throws ContaNaoEncontradaException;

    void atualizar(long id, ContaAbstrata conta) throws ContaNaoEncontradaException;

    boolean existe(String numero);
    
    boolean existe(long id);

    ContaAbstrata consultar(String numero) throws ContaNaoEncontradaException;
    
    ContaAbstrata consultar(long id) throws ContaNaoEncontradaException;

    List<ContaAbstrata> consultar(Cliente cliente);

    List<ContaAbstrata> listar();
}
