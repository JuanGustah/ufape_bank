package br.edu.ufape.bank.negocio.entidade;

import br.edu.ufape.bank.negocio.excecao.conta.SaldoInsuficienteException;
import jakarta.persistence.Entity;

@Entity
public class Conta extends ContaAbstrata{
    public Conta() {
    }
    
    public Conta(Cliente cliente,String numero,double saldo) {
    	super(cliente,numero,saldo);
    }

    @Override
    public void debitar(double valor) throws SaldoInsuficienteException {
        if (valor < 0) {
            throw new IllegalArgumentException();
        }

        if (this.saldo < valor) {
            throw new SaldoInsuficienteException(saldo, valor);
        } else {
            this.saldo -= valor;
        }
    }
}
