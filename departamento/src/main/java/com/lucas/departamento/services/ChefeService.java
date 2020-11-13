package com.lucas.departamento.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.departamento.entity.Chefe;
import com.lucas.departamento.exception.ResourceNotFoundException;
import com.lucas.departamento.repository.ChefeRepository;

@Service
public class ChefeService {
	
	private final ChefeRepository chefeRepository;

	@Autowired
	public ChefeService(ChefeRepository chefeRepository) {
		this.chefeRepository = chefeRepository;
	}

	@Transactional
	public void save(Chefe chefe) {
		
		if(chefe.getFuncionarioDepartamento() != null) 
			registrarHistoriaDepartamento(chefe);
		
		chefeRepository.save(chefe);
	}
	
	@Transactional
	public Chefe update(Chefe chefe) {
		final Optional<Chefe> OptionalChefe = chefeRepository
				.findById(chefe.getFuncionarioId());
		
		if(!OptionalChefe.isPresent()) {
			throw new ResourceNotFoundException("No records found for this ID");
		}
		
		chefe.setHistoriaDepartamento(OptionalChefe.get().getHistoriaDepartamento());
		
		if(chefe.getFuncionarioDepartamento() != null) 
			registrarHistoriaDepartamento(chefe);
		
		return chefeRepository.save(chefe);
	}
	
	private void registrarHistoriaDepartamento(Chefe chefe) {
		if(chefe.getHistoriaDepartamento() == null)
			chefe.setHistoriaDepartamento(new ArrayList<>());
		
		chefe.getHistoriaDepartamento().add(chefe.getFuncionarioDepartamento());
	}
	
	@Transactional
	public void delete(Long id) {
		Chefe chefe = chefeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		chefeRepository.delete(chefe);
	}
	
	public Chefe findById(Long id) {
		Chefe chefe = chefeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return chefe;
	}
	
	public List<Chefe> findAll() {
		return chefeRepository.findAll();
	}
	
}
