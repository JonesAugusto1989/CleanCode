package br.edu.infnet.cleancode.cleancode.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.cleancode.cleancode.API.AddressClient;
import br.edu.infnet.cleancode.cleancode.model.dto.PessoaFisicaRegisterDTO;
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
	public ResponseEntity<List<PessoaFisica>> findAll() {
		
		List<PessoaFisica> personList= fisicaServiceImpl.findAll();
		
		return ResponseEntity.ok(personList);
	}
	
	@PostMapping
	public ResponseEntity salvarPessoaFisica(@RequestBody PessoaFisicaRegisterDTO pessoaFisicaRegisterDTO) {
		System.out.println(pessoaFisicaRegisterDTO);
		
		try {
			PessoaFisica pessoaSalva = fisicaServiceImpl.savePessoaFisica(pessoaFisicaRegisterDTO);
			return ResponseEntity.ok(pessoaSalva);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Json invalido"+pessoaFisicaRegisterDTO);
		}
			
	}

}
