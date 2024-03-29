package br.edu.ufape.bank.negocio.entidade;

import jakarta.persistence.Entity;

@Entity
public class ContaPoupanca extends Conta{
    private double juros;

    public ContaPoupanca() {
        this.juros = 0.2;
    }
    
    public ContaPoupanca(Cliente cliente,String numero,double saldo) {
    	super(cliente,numero,saldo);
    	this.juros = 0.2;
    }
    
    public void renderJuros() {
        this.creditar(this.saldo * this.juros);
    }
}
