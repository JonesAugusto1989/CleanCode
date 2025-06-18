package br.edu.infnet.cleancode.cleancode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.cleancode.cleancode.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
