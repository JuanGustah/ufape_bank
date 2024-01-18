package br.edu.ufape.bank.negocio.excecao.conta;

public class ClienteNaoEncontradoException extends Exception{
	public ClienteNaoEncontradoException() {
		super("Cliente não encontrado.");
	}
}
