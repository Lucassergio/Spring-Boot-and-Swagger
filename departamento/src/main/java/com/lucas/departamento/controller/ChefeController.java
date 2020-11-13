package com.lucas.departamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.departamento.entity.Chefe;
import com.lucas.departamento.services.ChefeService;

@RestController
@RequestMapping("/chefe")
public class ChefeController {

	private final ChefeService chefeService;

	@Autowired
	public ChefeController(ChefeService chefeService) {
		this.chefeService = chefeService;
	}
	
	@GetMapping(value = "/{id}", produces = { "application/json" })
	public Chefe findById(@PathVariable("id") Long id) {
		Chefe chefe = chefeService.findById(id);
		return chefe;
	}
	
	@GetMapping(produces = { "application/json" })
	public List<Chefe> findAll() {
		List<Chefe> chefes = chefeService.findAll();
		return chefes;
	}
	
	@PostMapping(produces = { "application/json" }, consumes = {
			"application/json" })
	public ResponseEntity<?> create(@RequestBody Chefe chefe) {
		chefeService.save(chefe);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(produces = { "application/json" }, consumes = {
			"application/json" })
	public ResponseEntity<?> update(@RequestBody Chefe chefe) {
		chefeService.update(chefe);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		chefeService.delete(id);
		return ResponseEntity.ok().build();
	}
}
