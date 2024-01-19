package br.edu.ufape.bank.negocio.excecao.conta;

public class ContaNaoEncontradaException extends Exception{
	public ContaNaoEncontradaException() {
		super("Conta não encontrada.");
	}
}
