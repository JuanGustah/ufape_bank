package br.edu.ufape.bank.negocio.entidade;

import br.edu.ufape.bank.negocio.excecao.conta.SaldoInsuficienteException;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Conta extends ContaAbstrata{
    public Conta() {
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
