package br.edu.infnet.cleancode.cleancode.model.entity;

import jakarta.persistence.Entity;

@Entity
public class PessoaFisica extends User{

	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "PessoaFisica [cpf=" + cpf + "]";
	}
	
	
	
}
