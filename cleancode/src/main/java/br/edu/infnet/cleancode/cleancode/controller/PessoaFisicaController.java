package br.edu.infnet.cleancode.cleancode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.cleancode.cleancode.API.AddressClient;
import br.edu.infnet.cleancode.cleancode.model.entity.Address;
import br.edu.infnet.cleancode.cleancode.model.entity.PessoaFisica;
import br.edu.infnet.cleancode.cleancode.service.Impl.AddressServiceImpl;
import br.edu.infnet.cleancode.cleancode.service.Impl.PessoaFisicaServiceImpl;

@RestController
@RequestMapping("/API/PessoaFisicaController")
public class PessoaFisicaController {
	
	@Autowired
	final PessoaFisicaServiceImpl fisicaServiceImpl;
	
	@Autowired
	AddressClient addressClient;
	@Autowired
	AddressServiceImpl addressServiceImpl;
	
	PessoaFisicaController(PessoaFisicaServiceImpl fisicaServiceImpl){
		this.fisicaServiceImpl = fisicaServiceImpl;
	}
	
	@GetMapping
	public List<PessoaFisica>findAll() {
		return fisicaServiceImpl.findAll();
	}
	
	/*Acertar isso.
	
	Acertar a lista endereço.  decidir se pode ter um ou mais endereços
	
	
	
	*/
	@PostMapping
	public PessoaFisica salvarPessoaFisica(@RequestBody PessoaFisica pessoa) {
		System.out.println(pessoa);
		
		List<Address> address1 = pessoa.getAddress();
		
		String cep = address1.get(0).getCep();
		Address address = addressClient.obterPorCep(cep);
		address1.add(address);
		pessoa.setAddress(address1);
		PessoaFisica pessoaSalva = fisicaServiceImpl.savePessoaFisica(pessoa);
		return pessoaSalva;
	}

}
