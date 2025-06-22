package br.edu.infnet.cleancode.cleancode.API;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.cleancode.cleancode.model.dto.AddressDTO;

@FeignClient(url = "https://viacep.com.br/ws",name = "viaCep" )
public interface AddressClient {

	@GetMapping("/{cep}/json/")
	AddressDTO obterPorCep(@PathVariable String cep);
	

	
}
