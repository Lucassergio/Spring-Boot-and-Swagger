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

import com.lucas.departamento.entity.Cargo;
import com.lucas.departamento.services.CargoService;

@RestController
@RequestMapping("/cargo")
public class CargoController {

	private final CargoService cargoService;

	@Autowired
	public CargoController(CargoService cargoService) {
		this.cargoService = cargoService;
	}
	
	@GetMapping(value = "/{id}", produces = { "application/json" })
	public Cargo findById(@PathVariable("id") Long id) {
		Cargo cargo = cargoService.findById(id);
		return cargo;
	}
	
	@GetMapping(produces = { "application/json" })
	public List<Cargo> findAll() {
		List<Cargo> cargos = cargoService.findAll();
		return cargos;
	}
	
	@PostMapping(produces = { "application/json" }, consumes = {
			"application/json" })
	public ResponseEntity<?> create(@RequestBody Cargo cargo) {
		cargoService.save(cargo);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(produces = { "application/json" }, consumes = {
			"application/json" })
	public ResponseEntity<?> update(@RequestBody Cargo cargo) {
		cargoService.update(cargo);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		cargoService.delete(id);
		return ResponseEntity.ok().build();
	}
}
