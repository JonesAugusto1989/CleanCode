package br.edu.infnet.cleancode.cleancode.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.cleancode.cleancode.API.AddressClient;
import br.edu.infnet.cleancode.cleancode.adapter.AddressAdapterInterface;
import br.edu.infnet.cleancode.cleancode.exceptions.AddressNotFound;
import br.edu.infnet.cleancode.cleancode.model.dto.AddressDTO;
import br.edu.infnet.cleancode.cleancode.model.dto.ComplementoUnidade;
import br.edu.infnet.cleancode.cleancode.model.entity.Address;
import br.edu.infnet.cleancode.cleancode.repository.AddressRepository;
import br.edu.infnet.cleancode.cleancode.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private final AddressClient addressClient;
	
	@Autowired
	private final AddressAdapterInterface addressAdapter;
	
	
	@Autowired
	private final AddressRepository addressRepository;
	
	public AddressServiceImpl(AddressRepository addressRepository, AddressAdapterInterface addressAdapter,AddressClient addressClient) {
	    this.addressRepository = addressRepository;
	    this.addressAdapter = addressAdapter;
	    this.addressClient = addressClient;
	}
	
	
	public List<Address> findAll() {
		List<Address> addressList = addressRepository.findAll();
		return addressList;
	}
	

	
	
	public Address obterPorCep(String cep,ComplementoUnidade complementoUnidade) {
		
	    AddressDTO addressDTO = addressClient.obterPorCep(cep);
	    
        return addressAdapter.dtoConvertEntity(addressDTO, complementoUnidade);
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
