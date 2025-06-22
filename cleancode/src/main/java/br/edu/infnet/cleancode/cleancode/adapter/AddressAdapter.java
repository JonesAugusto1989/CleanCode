package br.edu.infnet.cleancode.cleancode.adapter;

import org.springframework.stereotype.Component;

import br.edu.infnet.cleancode.cleancode.model.dto.AddressDTO;
import br.edu.infnet.cleancode.cleancode.model.dto.ComplementoUnidade;
import br.edu.infnet.cleancode.cleancode.model.entity.Address;
@Component
public class AddressAdapter implements AddressAdapterInterface {

	@Override
	public Address dtoConvertEntity(AddressDTO dto, ComplementoUnidade complementoUnidade) {
		 return new Address.Builder()
	                .cep(dto.getCep())
	                .logradouro(dto.getLogradouro())
	                .complemento(complementoUnidade.complemento())
	                .unidade(complementoUnidade.unidade())
	                .bairro(dto.getBairro())
	                .localidade(dto.getLocalidade())
	                .uf(dto.getUf())
	                .estado(dto.getEstado())
	                .regiao(dto.getRegiao())
	                .build();
	}
	}