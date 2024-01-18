package br.edu.ufape.bank.negocio.excecao.cliente;

public class ClienteNaoEncontradoException extends Exception{
	public ClienteNaoEncontradoException() {
		super("Cliente não encontrado.");
	}
}
