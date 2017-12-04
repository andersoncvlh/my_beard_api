package com.mybeardapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybeardapi.model.Usuario;
import com.mybeardapi.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepositoy;
	
	public Usuario findOne(Long id) {
		return usuarioRepositoy.findOne(id);
	}
	
	public List<Usuario> findByFilter() {
		return usuarioRepositoy.findAll();
	}
	
	public Optional<Usuario> findByEmail(String email) {
		return usuarioRepositoy.findByEmail(email);
	}
	
	public Usuario salvarUsuario(Usuario entity) {
		return usuarioRepositoy.save(entity);
	}
	
	public void deletarUsuario(Long id) {
		usuarioRepositoy.delete(id);
	}
	
}
