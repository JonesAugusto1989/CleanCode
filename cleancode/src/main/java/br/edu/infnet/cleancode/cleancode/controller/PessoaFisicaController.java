package br.edu.infnet.cleancode.cleancode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.cleancode.cleancode.exceptions.UserNotFound;
import br.edu.infnet.cleancode.cleancode.model.dto.PessoaFisicaRegisterDTO;
import br.edu.infnet.cleancode.cleancode.model.entity.PessoaFisica;
import br.edu.infnet.cleancode.cleancode.model.entity.User;
import br.edu.infnet.cleancode.cleancode.service.PessoaFisicaService;

@RestController
@RequestMapping("/API/PessoaFisicaController")
public class PessoaFisicaController {

	@Autowired
	final PessoaFisicaService fisicaService;

	PessoaFisicaController(PessoaFisicaService fisicaService) {
		this.fisicaService = fisicaService;
	}

	@GetMapping
	public ResponseEntity<List<PessoaFisica>> findAll() {

		List<PessoaFisica> personList = fisicaService.findAll();

		return ResponseEntity.ok(personList);
	}

	@PostMapping
	public ResponseEntity salvarPessoaFisica(@RequestBody PessoaFisicaRegisterDTO pessoaFisicaRegisterDTO) {
		System.out.println(pessoaFisicaRegisterDTO);

		try {
			PessoaFisica pessoaSalva = fisicaService.savePessoaFisica(pessoaFisicaRegisterDTO);
			return ResponseEntity.ok(pessoaSalva);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Json invalido" + pessoaFisicaRegisterDTO);
		}

	}

	@GetMapping("/{cpf}")
	public ResponseEntity findByCpf(@PathVariable("cpf") String cpf) {

		try {
			User userFound = fisicaService.findByCpf(cpf);
			return ResponseEntity.ok(userFound);
		} catch (UserNotFound e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum cpf encontrado");
		}

	}

}
