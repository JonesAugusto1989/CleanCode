package br.edu.infnet.cleancode.cleancode.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.cleancode.cleancode.exceptions.UserNotFound;
import br.edu.infnet.cleancode.cleancode.model.dto.PessoaFisicaDTO;
import br.edu.infnet.cleancode.cleancode.model.entity.PessoaFisica;
import br.edu.infnet.cleancode.cleancode.repository.PessoaFisicaRepository;
import br.edu.infnet.cleancode.cleancode.service.PessoaFisicaService;
import br.edu.infnet.cleancode.cleancode.service.UserService;

@Service
public class PessoaFisicaServiceImpl implements PessoaFisicaService{
	
	
	
	@Autowired
	private final PessoaFisicaRepository pessoafisicaRepository;
	
	

	public PessoaFisicaServiceImpl(PessoaFisicaRepository pessoafisicaRepository) {
	
		this.pessoafisicaRepository = pessoafisicaRepository;
	
	}

	@Override
	public List<PessoaFisica> findAll() {
		List<PessoaFisica> personList = pessoafisicaRepository.findAll();
		return personList;
	}
	
	public PessoaFisica savePessoaFisica(PessoaFisica pessoa) {
		
		pessoafisicaRepository.save(pessoa);	
		return pessoa;
		
	}

	@Override
	public Optional<PessoaFisica> findById(Long id) {
		
		Optional<PessoaFisica> pessoaFound = pessoafisicaRepository.findById(id);
		
		if(pessoaFound.isEmpty()) {
			throw new UserNotFound("Não encontrada pessoa fisica com o id: " + id);
		}
		
		return pessoaFound;
	}

	@Override
	public PessoaFisica deleteById(long id) {
		
		PessoaFisica found = pessoaFisicaIsPresent(id);

		pessoafisicaRepository.deleteById(id);	
		
		return found;
		
	}
	
	public PessoaFisica updatePessoaFisica(PessoaFisica pessoaFisica, PessoaFisicaDTO pessoaFisicaDTO) {
		
		PessoaFisica found = pessoaFisicaIsPresent(pessoaFisica.getId());
		
		Optional.ofNullable(pessoaFisicaDTO.name()).ifPresent(found::setName);
		Optional.ofNullable(pessoaFisicaDTO.address()).ifPresent(found::setAddress);
		//Optional.ofNullable(pessoaFisicaDTO.apolices()).ifPresent(found::setApolices);
		pessoafisicaRepository.save(found);
		return found;
	}
	
	private PessoaFisica pessoaFisicaIsPresent(long id) {
		PessoaFisica pessoaFound = pessoafisicaRepository.findById(id).orElseThrow((() -> new UserNotFound("Não encontrada pessoa fisica com o {}"+id)));
		
		return pessoaFound;
	}
}
