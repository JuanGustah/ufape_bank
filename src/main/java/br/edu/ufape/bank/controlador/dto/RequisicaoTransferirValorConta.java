package br.edu.ufape.bank.controlador.dto;

public class RequisicaoTransferirValorConta {
	private long idContaOrigem;
	private long idContaDestino;
	private double valor;
	
	public long getIdContaOrigem() {
		return idContaOrigem;
	}
	public void setIdContaOrigem(long idClienteOrigem) {
		this.idContaOrigem = idClienteOrigem;
	}
	public long getIdContaDestino() {
		return idContaDestino;
	}
	public void setIdContaDestino(long idClienteDestino) {
		this.idContaDestino = idClienteDestino;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
