package br.edu.infnet.cleancode.cleancode.service;

import br.edu.infnet.cleancode.cleancode.model.dto.PessoaFisicaRegisterDTO;
import br.edu.infnet.cleancode.cleancode.model.entity.PessoaFisica;

public interface PessoaFisicaService extends UserService<PessoaFisica>{

	 PessoaFisica findByCpf(String cpf);
	
	 PessoaFisica savePessoaFisica(PessoaFisicaRegisterDTO pessoaFisicaRegisterDTO);
	
}
