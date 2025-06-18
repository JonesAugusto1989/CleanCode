package br.edu.infnet.cleancode.cleancode.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.cleancode.cleancode.API.AddressClient;
import br.edu.infnet.cleancode.cleancode.exceptions.AddressNotFound;
import br.edu.infnet.cleancode.cleancode.exceptions.UserNotFound;
import br.edu.infnet.cleancode.cleancode.model.entity.Address;
import br.edu.infnet.cleancode.cleancode.model.entity.PessoaFisica;
import br.edu.infnet.cleancode.cleancode.repository.AddressRepository;
import br.edu.infnet.cleancode.cleancode.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressClient addressClient;
	
	
	@Autowired
	private final AddressRepository addressRepository;
	
	
	public List<Address> findAll() {
		List<Address> addressList = addressRepository.findAll();
		return addressList;
	}
	
	public Address saveAddress(String cep) {
		
		Address address = addressClient.obterPorCep(cep);
		
		addressRepository.save(address);
		return address;
	}
	
	
	
	public AddressServiceImpl(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	
	public Address obterPorCep(String cep) {
		return addressClient.obterPorCep(cep);
	}

	@Override
	public Address findByCep(String cep) {
		
		Optional<Address> addressFound = addressRepository.findByCep(cep);
		if(addressFound.isEmpty()) {
			throw new AddressNotFound("Endereço não encontrado para o cep: "+cep);
		}
		
		return addressFound.get();
	}

}
