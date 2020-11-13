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

import com.lucas.departamento.entity.Departamento;
import com.lucas.departamento.services.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

	private final DepartamentoService departamentoService;

	@Autowired
	public DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}
	
	@GetMapping(value = "/{id}", produces = { "application/json"})
	public Departamento findById(@PathVariable("id") Long id) {
		Departamento departamento = departamentoService.findById(id);
		return departamento;
	}
	
	@GetMapping(produces = { "application/json" })
	public List<Departamento> findAll() {
		List<Departamento> departamentos = departamentoService.findAll();
		return departamentos;
	}
	
	@PostMapping(produces = { "application/json" }, consumes = {
			"application/json" })
	public ResponseEntity<?> create(@RequestBody Departamento departamento) {
		departamentoService.save(departamento);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(produces = { "application/json"}, consumes = {
			"application/json" })
	public ResponseEntity<?> update(@RequestBody Departamento departamento) {
		departamentoService.update(departamento);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		departamentoService.delete(id);
		return ResponseEntity.ok().build();
	}
}
