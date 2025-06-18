package br.edu.infnet.cleancode.cleancode.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.cleancode.cleancode.repository.ApoliceRepository;

//@Service
public class ApoliceServiceImpl {

	//@Autowired
	private final ApoliceRepository apoliceRepository;
	
	public ApoliceServiceImpl(ApoliceRepository apoliceRepository) {
		this.apoliceRepository = apoliceRepository;
	}
	
	
}
