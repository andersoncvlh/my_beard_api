package com.mybeardapi.resources;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybeardapi.event.RecursoCriadoEvent;
import com.mybeardapi.model.Usuario;
import com.mybeardapi.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource extends AbstractResource {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findByFilter() {
		List<Usuario> usuarios = usuarioService.findByFilter();
		return !usuarios.isEmpty() ? ResponseEntity.ok(usuarios) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {
		Usuario usuario = usuarioService.findOne(id);
		return null != usuario ? ResponseEntity.ok(usuario) : ResponseEntity.noContent().build();  
	}
	
	@PostMapping
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody @Valid Usuario usuario, HttpServletResponse response) {
		Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
		getPublisher().publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removerUsuario(@PathVariable Long id) {
		usuarioService.deletarUsuario(id);
		return ResponseEntity.noContent().build();
	}
	
}
