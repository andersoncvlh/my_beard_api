package com.mybeardapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
