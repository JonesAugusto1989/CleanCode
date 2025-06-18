package br.edu.infnet.cleancode.cleancode.service;

import br.edu.infnet.cleancode.cleancode.model.entity.Address;

public interface AddressService {

	
	Address findByCep(String cep);
}
