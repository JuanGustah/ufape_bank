package br.edu.ufape.bank.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufape.bank.negocio.entidade.Cliente;

public interface IColecaoCliente extends JpaRepository<Cliente, Long>{

}