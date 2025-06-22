package br.edu.infnet.cleancode.cleancode.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.cleancode.cleancode.exceptions.CpfInvalid;
import br.edu.infnet.cleancode.cleancode.exceptions.UserNotFound;
import br.edu.infnet.cleancode.cleancode.model.dto.ComplementoUnidade;
import br.edu.infnet.cleancode.cleancode.model.dto.PessoaFisicaDTO;
import br.edu.infnet.cleancode.cleancode.model.dto.PessoaFisicaRegisterDTO;
import br.edu.infnet.cleancode.cleancode.model.entity.Address;
import br.edu.infnet.cleancode.cleancode.model.entity.PessoaFisica;
import br.edu.infnet.cleancode.cleancode.repository.PessoaFisicaRepository;
import br.edu.infnet.cleancode.cleancode.service.AddressService;
import br.edu.infnet.cleancode.cleancode.service.PessoaFisicaService;
@Service
public class PessoaFisicaServiceImpl implements PessoaFisicaService {

	@Autowired
	private final PessoaFisicaRepository pessoaFisicaRepository;
	
	@Autowired
	private final AddressService addressService;

	public PessoaFisicaServiceImpl(PessoaFisicaRepository pessoafisicaRepository, AddressService addressService) {
		this.pessoaFisicaRepository = pessoafisicaRepository;
		this.addressService = addressService;
		
	}

	@Override
	public List<PessoaFisica> findAll() {
		List<PessoaFisica> personList = pessoaFisicaRepository.findAll();
		return personList;
	}

	public PessoaFisica savePessoaFisica(PessoaFisicaRegisterDTO pessoaFisicaRegisterDTO) {

		String cep = pessoaFisicaRegisterDTO.cep();
		
		
		
		ComplementoUnidade complementoUnidade = new ComplementoUnidade(pessoaFisicaRegisterDTO.complemento(), pessoaFisicaRegisterDTO.unidade());
			
		
		Address address = addressService.obterPorCep(cep, complementoUnidade);
	
		PessoaFisica pessoa = convertDtoToPessoa(pessoaFisicaRegisterDTO, address);
		boolean cpfValido = pessoa.executarValidacao(); 
		 if (!cpfValido) {
			 throw new CpfInvalid("CPF inválido.");
		 }   
		pessoaFisicaRepository.save(pessoa);
		
		return pessoa;
	
	}

	private PessoaFisica convertDtoToPessoa(PessoaFisicaRegisterDTO pessoaFisicaRegisterDTO, Address address) {
		PessoaFisica pessoa = new PessoaFisica();
		pessoa.setName(pessoaFisicaRegisterDTO.name());
		pessoa.setCpf(pessoaFisicaRegisterDTO.cpf());
		List<Address> addressList = new ArrayList<>();
		addressList.add(address);
		pessoa.setAddress(addressList);
		address.setUser(pessoa);
		return pessoa;
	}

	@Override
	public Optional<PessoaFisica> findById(Long id) {

		Optional<PessoaFisica> pessoaFound = pessoaFisicaRepository.findById(id);

		if (pessoaFound.isEmpty()) {
			throw new UserNotFound("Não encontrada pessoa fisica com o id: " + id);
		}

		return pessoaFound;
	}

	@Override
	public PessoaFisica deleteById(long id) {

		PessoaFisica found = pessoaFisicaIsPresent(id);

		pessoaFisicaRepository.deleteById(id);

		return found;

	}

	public PessoaFisica updatePessoaFisica(PessoaFisica pessoaFisica, PessoaFisicaDTO pessoaFisicaDTO) {

		PessoaFisica found = pessoaFisicaIsPresent(pessoaFisica.getId());

		Optional.ofNullable(pessoaFisicaDTO.name()).ifPresent(found::setName);
		Optional.ofNullable(pessoaFisicaDTO.address()).ifPresent(found::setAddress);
		pessoaFisicaRepository.save(found);
		return found;
	}

	private PessoaFisica pessoaFisicaIsPresent(long id) {
		PessoaFisica pessoaFound = pessoaFisicaRepository.findById(id)
				.orElseThrow((() -> new UserNotFound("Não encontrada pessoa fisica com o {}" + id)));

		return pessoaFound;
	}


	@Override
	public PessoaFisica findByCpf(String cpf) {

		Optional<PessoaFisica> pessoaFound = pessoaFisicaRepository.findByCpf(cpf);

		if (pessoaFound.isEmpty()) {
			throw new UserNotFound("Não encontrada pessoa fisica com o id: " + cpf);
		}

		return pessoaFound.get();
	}
}
