package com.mybeardapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybeardapi.model.Permissao;
import com.mybeardapi.repositories.PermissaoRepository;

@Service
public class PermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	public Permissao findByDescricao(String descricao) {
		return permissaoRepository.findByDescricao(descricao);
	}
	
	public List<Permissao> findByFilter() {
		return permissaoRepository.findAll();
	}
	
	public Permissao salvarPermissao(Permissao entity) {
		return permissaoRepository.save(entity);
	}
	
	public void deletarPermissao(Long id) {
		permissaoRepository.delete(id);
	}
	
}
