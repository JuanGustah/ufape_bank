package br.edu.ufape.bank.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufape.bank.negocio.entidade.ContaAbstrata;

public interface IColecaoConta extends JpaRepository<ContaAbstrata, Long>{

}
