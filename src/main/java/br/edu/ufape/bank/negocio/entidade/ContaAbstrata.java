package br.edu.ufape.bank.negocio.entidade;

import br.edu.ufape.bank.negocio.excecao.conta.SaldoInsuficienteException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ContaAbstrata {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	protected Cliente cliente;
    protected String numero;
    protected double saldo;

    public ContaAbstrata() {
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void creditar(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException();
        }
        saldo += valor;
    }

    public abstract void debitar(double valor) throws SaldoInsuficienteException;

    public void transferir(ContaAbstrata conta, double valor) throws SaldoInsuficienteException {
        if (valor < 0) {
            throw new IllegalArgumentException();
        }
        this.debitar(valor);
        conta.creditar(valor);
    }

    @Override
    public String toString() {
        return "numero da conta: " + numero + "; titular: " + cliente.getNome();
    }
}
