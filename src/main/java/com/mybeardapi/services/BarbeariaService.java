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
	
	public Barbearia salvar(Barbearia entity) {
		return barbeariaRepository.save(entity);
	}
	
	public Barbearia findOne(Long id) {
		return barbeariaRepository.findOne(id);
	}
	
	public void removerBarbearia(Long id) {
		barbeariaRepository.delete(id);
	}
	
}
