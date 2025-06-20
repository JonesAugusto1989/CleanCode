package br.edu.infnet.cleancode.cleancode.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.cleancode.cleancode.API.AddressClient;
import br.edu.infnet.cleancode.cleancode.exceptions.UserNotFound;
import br.edu.infnet.cleancode.cleancode.model.dto.PessoaFisicaDTO;
import br.edu.infnet.cleancode.cleancode.model.dto.PessoaFisicaRegisterDTO;
import br.edu.infnet.cleancode.cleancode.model.entity.Address;
import br.edu.infnet.cleancode.cleancode.model.entity.PessoaFisica;
import br.edu.infnet.cleancode.cleancode.repository.PessoaFisicaRepository;
import br.edu.infnet.cleancode.cleancode.service.PessoaFisicaService;
import br.edu.infnet.cleancode.cleancode.service.UserService;

@Service
public class PessoaFisicaServiceImpl implements PessoaFisicaService{
	
	
	
	@Autowired
	private final PessoaFisicaRepository pessoafisicaRepository;
	
	@Autowired
	private final AddressClient addressClient;
	
	

	public PessoaFisicaServiceImpl(PessoaFisicaRepository pessoafisicaRepository, AddressClient addressClient) {
	
		this.pessoafisicaRepository = pessoafisicaRepository;
		this.addressClient = addressClient;
	
	}

	@Override
	public List<PessoaFisica> findAll() {
		List<PessoaFisica> personList = pessoafisicaRepository.findAll();
		return personList;
	}
	
	public PessoaFisica savePessoaFisica(PessoaFisicaRegisterDTO pessoaFisicaRegisterDTO) {
		
		String cep = pessoaFisicaRegisterDTO.cep();
		System.out.println(pessoaFisicaRegisterDTO);
		PessoaFisica pessoa = new PessoaFisica();
		
		pessoa.setName(pessoaFisicaRegisterDTO.name());
		pessoa.setCpf(pessoaFisicaRegisterDTO.cpf());
				
		List<Address> addressList = new ArrayList<Address>();
		
		
		
		Address address = addressClient.obterPorCep(cep);		
		address.setComplemento(pessoaFisicaRegisterDTO.complemento());
		address.setUnidade(pessoaFisicaRegisterDTO.unidade());
		address.setUser(pessoa);
		addressList.add(address);	
		pessoa.setAddress(addressList);	
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

	private PessoaFisica pessoaFisicaIsPresent(String cpf) {
		PessoaFisica pessoaFound = pessoafisicaRepository.findByCpf(cpf).orElseThrow((() -> new UserNotFound("Não encontrada pessoa fisica com o {}"+cpf)));
		
		return pessoaFound;
	}

	
	@Override
	public PessoaFisica findByCpf(String cpf) {
		
		Optional<PessoaFisica> pessoaFound = pessoafisicaRepository.findByCpf(cpf);
		
		if(pessoaFound.isEmpty()) {
			throw new UserNotFound("Não encontrada pessoa fisica com o id: " + cpf);
		}
		
		return pessoaFound.get();
	}
}
