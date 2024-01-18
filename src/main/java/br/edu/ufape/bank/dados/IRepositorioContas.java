package br.edu.ufape.bank.dados;

import java.util.ArrayList;

import br.edu.ufape.bank.negocio.entidade.Cliente;
import br.edu.ufape.bank.negocio.entidade.ContaAbstrata;

public interface IRepositorioContas {

    void adicionar(ContaAbstrata conta);

    void remover(ContaAbstrata conta);

    void atualizar(ContaAbstrata conta);

    boolean existe(String numero);
    
    boolean existe(long id);

    ContaAbstrata consultar(ContaAbstrata conta);

    ContaAbstrata consultar(String numero);
    
    ContaAbstrata consultar(long id);

    ArrayList<ContaAbstrata> consultar(Cliente cliente);

    void listar();
}
