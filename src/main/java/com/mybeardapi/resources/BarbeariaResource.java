package com.mybeardapi.resources;

import java.util.List;

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

import com.mybeardapi.model.Barbearia;
import com.mybeardapi.services.BarbeariaService;

@RestController
@RequestMapping("/barbearias")
public class BarbeariaResource {

	@Autowired
	private BarbeariaService barbeariaService;
	
	@GetMapping
	public ResponseEntity<List<Barbearia>> findByFilter() {
		List<Barbearia> barbearias = barbeariaService.findByFilter();
		return !barbearias.isEmpty() ? ResponseEntity.ok(barbeariaService.findByFilter()) : ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Barbearia> save(@RequestBody Barbearia nova) {
		return ResponseEntity.status(HttpStatus.CREATED).body(barbeariaService.salvar(nova));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Barbearia> findOne(@PathVariable Long id) {
		Barbearia barbearia = barbeariaService.findOne(id);
		return barbearia != null ? ResponseEntity.ok(barbearia) : ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removerBarbearia(@PathVariable Long id) {
		barbeariaService.removerBarbearia(id);
		return ResponseEntity.noContent().build();
	}
	
}
