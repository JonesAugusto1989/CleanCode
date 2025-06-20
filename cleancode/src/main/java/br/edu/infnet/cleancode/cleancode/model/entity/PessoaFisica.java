package br.edu.infnet.cleancode.cleancode.model.entity;

import br.edu.infnet.cleancode.cleancode.exceptions.CpfInvalid;
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

	@Override
	protected void validarDados() {
		if(cpf == null || cpf.length()<=11 ) {
			throw new CpfInvalid("Cpf Invalido");
		}
		
	}
	
	
	
}
