package br.edu.ufape.bank.negocio.excecao.conta;

public class SaldoInsuficienteException extends Exception {
	 public SaldoInsuficienteException(double saldo, double valor) {
        super("Saldo insuficiente. Saldo atual: "+saldo+"; Valor desejado: "+valor);
    }
}
