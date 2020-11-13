package com.lucas.departamento.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.departamento.entity.Departamento;
import com.lucas.departamento.exception.ResourceNotFoundException;
import com.lucas.departamento.repository.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	private final DepartamentoRepository departamentoRepository;

	@Autowired
	public DepartamentoService(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}

	@Transactional
	public void save(Departamento departamento) {
		departamentoRepository.save(departamento);
	}
	
	@Transactional
	public Departamento update(Departamento departamento) {
		departamentoRepository
				.findById(departamento.getDepartamentoId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		return departamentoRepository.save(departamento);
	}
	
	@Transactional
	public void delete(Long id) {
		Departamento departamento = departamentoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		departamentoRepository.delete(departamento);
	}
	
	public Departamento findById(Long id) {
		Departamento departamento = departamentoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return departamento;
	}
	
	public List<Departamento> findAll() {
		return departamentoRepository.findAll();
	}
	
}
