package br.edu.ufape.bank.negocio;

import java.util.List;

import br.edu.ufape.bank.negocio.entidade.Cliente;
import br.edu.ufape.bank.negocio.entidade.ContaAbstrata;
import br.edu.ufape.bank.negocio.excecao.conta.ContaNaoEncontradaException;
import br.edu.ufape.bank.negocio.excecao.conta.SaldoInsuficienteException;

public interface INegocioContas {

    void adicionar(ContaAbstrata conta);

    void remover(long id) throws ContaNaoEncontradaException;

    void atualizar(long id, Cliente cliente, String numero) throws ContaNaoEncontradaException;

    boolean existe(String numero);
    
    boolean existe(long id);

    ContaAbstrata consultar(String numero) throws ContaNaoEncontradaException;
    
    ContaAbstrata consultar(long id) throws ContaNaoEncontradaException;

    List<ContaAbstrata> consultar(Cliente cliente);

    List<ContaAbstrata> listar();
    
    void transferir(long idContaOrigem, long idContaDestino, double valor) throws SaldoInsuficienteException,ContaNaoEncontradaException;
    
    void debitar(long idConta, double valor) throws ContaNaoEncontradaException, SaldoInsuficienteException;
    
    void creditar(long idConta, double valor) throws ContaNaoEncontradaException;
}
