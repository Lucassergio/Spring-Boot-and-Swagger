package com.lucas.departamento.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.departamento.entity.Cargo;
import com.lucas.departamento.exception.ResourceNotFoundException;
import com.lucas.departamento.repository.CargoRepository;

@Service
public class CargoService {
	
	private final CargoRepository cargoRepository;

	@Autowired
	public CargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	@Transactional
	public void save(Cargo cargo) {
		cargoRepository.save(cargo);
	}
	
	@Transactional
	public Cargo update(Cargo cargo) {
		cargoRepository
				.findById(cargo.getCargoId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		return cargoRepository.save(cargo);
	}
	
	@Transactional
	public void delete(Long id) {
		Cargo cargo = cargoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		cargoRepository.delete(cargo);
	}
	
	public Cargo findById(Long id) {
		Cargo cargo = cargoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return cargo;
	}
	
	public List<Cargo> findAll() {
		return cargoRepository.findAll();
	}
	
}
