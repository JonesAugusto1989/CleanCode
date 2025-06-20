package br.edu.infnet.cleancode.cleancode.model.dto;

import java.util.List;

import br.edu.infnet.cleancode.cleancode.model.entity.Address;
import br.edu.infnet.cleancode.cleancode.model.entity.Apolice;

public record PessoaFisicaRegisterDTO(String name,String cpf, String cep, String unidade, String complemento) {

}
