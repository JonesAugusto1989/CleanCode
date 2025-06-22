package br.edu.infnet.cleancode.cleancode.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.cleancode.cleancode.model.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
	
	Optional<Address> findByCep(String cep);



}
