package br.edu.infnet.cleancode.cleancode.adapter;

import br.edu.infnet.cleancode.cleancode.model.dto.AddressDTO;
import br.edu.infnet.cleancode.cleancode.model.dto.ComplementoUnidade;
import br.edu.infnet.cleancode.cleancode.model.entity.Address;

public interface AddressAdapterInterface {
    Address dtoConvertEntity(AddressDTO dto, ComplementoUnidade compUnidade);
}