package com.mybeardapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybeardapi.model.Barbearia;
import com.mybeardapi.repositories.BarbeariaRepository;

@Service
public class BarbeariaService {

	@Autowired
	private BarbeariaRepository barbeariaRepository;
	
	public List<Barbearia> findByFilter() {
		return barbeariaRepository.findAll();
	}
	
}
