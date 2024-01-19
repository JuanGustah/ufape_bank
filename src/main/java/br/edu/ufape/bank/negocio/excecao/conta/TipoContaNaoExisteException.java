package br.edu.ufape.bank.negocio.excecao.conta;

public class TipoContaNaoExisteException extends Exception{
	public TipoContaNaoExisteException() {
        super("O tipo de conta indicado não existe.");
    }
}
