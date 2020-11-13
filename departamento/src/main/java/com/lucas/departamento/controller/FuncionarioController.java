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

import com.lucas.departamento.entity.Funcionario;
import com.lucas.departamento.services.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	private final FuncionarioService funcionarioService;

	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	
	@GetMapping(value = "/{id}", produces = { "application/json" })
	public Funcionario findById(@PathVariable("id") Long id) {
		Funcionario funcionario = funcionarioService.findById(id);
		return funcionario;
	}
	
	@GetMapping(produces = { "application/json" })
	public List<Funcionario> findAll() {
		List<Funcionario> funcionarios = funcionarioService.findAll();
		return funcionarios;
	}
	
	@GetMapping(value = "listarFuncionariosPorDepartamento/{id}", produces = { "application/json" })
	public List<Funcionario> listarFuncionariosPorDeparamento(@PathVariable("id") Long idDepartamento) {
		List<Funcionario> funcionarios = funcionarioService.listarFuncionariosPorDepartamento(idDepartamento);
		return funcionarios;
	}
	
	@PostMapping(produces = { "application/json" }, consumes = {
			"application/json" })
	public ResponseEntity<?> create(@RequestBody Funcionario funcionario) {
		funcionarioService.save(funcionario);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(produces = { "application/json" }, consumes = {
			"application/json" })
	public ResponseEntity<?> update(@RequestBody Funcionario funcionario) {
		funcionarioService.update(funcionario);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		funcionarioService.delete(id);
		return ResponseEntity.ok().build();
	}
}
