package br.edu.infnet.cleancode.cleancode.service;

import java.util.Optional;

import br.edu.infnet.cleancode.cleancode.model.entity.PessoaFisica;

public interface PessoaFisicaService extends UserService<PessoaFisica>{

	public PessoaFisica findByCpf(String cpf);
	
}
