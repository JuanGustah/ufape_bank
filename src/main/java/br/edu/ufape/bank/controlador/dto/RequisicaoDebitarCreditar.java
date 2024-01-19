package br.edu.ufape.bank.controlador.dto;

public class RequisicaoDebitarCreditar {
	private long idConta;
	private double valor;
	
	public long getIdConta() {
		return idConta;
	}
	public void setIdConta(long idConta) {
		this.idConta = idConta;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
