package br.edu.ufape.bank.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufape.bank.negocio.entidade.ContaAbstrata;

public interface IRepositorioConta extends JpaRepository<ContaAbstrata, Long>{
	public ContaAbstrata findByNumero(String numero);
	public List<ContaAbstrata> findByClienteId(long id);
}
