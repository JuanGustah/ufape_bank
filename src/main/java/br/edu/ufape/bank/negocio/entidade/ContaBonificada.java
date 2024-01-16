package br.edu.ufape.bank.negocio.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Transient;

@Entity
public class ContaBonificada extends Conta{
    private double bonus;
    @Transient
    private double taxaBonus;

    public ContaBonificada() {
        this.taxaBonus = 0.1;
    }

    @Override
    public void creditar(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException();
        }
        this.bonus += (valor * this.taxaBonus);
        super.creditar(valor);
    }

    public void renderBonus() {
        super.creditar(this.bonus);
        this.bonus = 0;
    }
}
