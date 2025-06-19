package br.edu.infnet.cleancode.cleancode.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.cleancode.cleancode.model.entity.PessoaFisica;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long>{
	
	public Optional<PessoaFisica> findByCpf(String cpf);

}
