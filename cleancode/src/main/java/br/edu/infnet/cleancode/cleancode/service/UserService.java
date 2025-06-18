package br.edu.infnet.cleancode.cleancode.service;

import java.util.List;
import java.util.Optional;

import br.edu.infnet.cleancode.cleancode.model.entity.User;

public interface UserService<T extends User> {

	
	 List<T> findAll();
	
	 Optional<T> findById(Long id);
	
	 T deleteById(long id);
	
}
