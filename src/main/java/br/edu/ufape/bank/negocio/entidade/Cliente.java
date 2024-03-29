package br.edu.ufape.bank.negocio.entidade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String cpf;
    private String nome;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    
    public Cliente() {
    	
    }

    public Cliente(String cpf, String nome) {
        this.nome = nome;
        this.cpf = cpf;
    }
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco){
		this.endereco = endereco;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cliente) {
            Cliente cliente = (Cliente) obj;
            if (this.cpf.equals(cliente.getCpf())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "nome do cliente: " + nome + "; cpf: " + cpf;
    }
}