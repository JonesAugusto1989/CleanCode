package br.edu.infnet.cleancode.cleancode.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.cleancode.cleancode.exceptions.UserNotFound;
import br.edu.infnet.cleancode.cleancode.model.entity.User;
import br.edu.infnet.cleancode.cleancode.repository.UserRepository;
import br.edu.infnet.cleancode.cleancode.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private final UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}
	
	public User deleteById(long id) {
		
		Optional<User> userFound = userRepository.findById(id);
		
		if(userFound.isEmpty()) {
			throw new UserNotFound("Não encontrado com o Id" + id); 
		}
		userRepository.deleteById(id);
		
		return userFound.get();	
	}
	
	
	
	
}
