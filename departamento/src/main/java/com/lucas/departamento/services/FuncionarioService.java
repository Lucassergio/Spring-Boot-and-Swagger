package com.lucas.departamento.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.departamento.entity.Funcionario;
import com.lucas.departamento.exception.ResourceNotFoundException;
import com.lucas.departamento.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	private final FuncionarioRepository funcionarioRepository;
	
	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	@Transactional
	public void save(Funcionario funcionario) {
		
		if(funcionario.getFuncionarioDepartamento() != null) 
			registrarHistoriaDepartamento(funcionario);
		
		funcionarioRepository.save(funcionario);
	}
	
	@Transactional
	public Funcionario update(Funcionario funcionario) {
		final Optional<Funcionario> OptionalFuncionario = funcionarioRepository
				.findById(funcionario.getFuncionarioId());
		
		if(!OptionalFuncionario.isPresent()) {
			throw new ResourceNotFoundException("No records found for this ID");
		}
		
		funcionario.setHistoriaDepartamento(OptionalFuncionario.get().getHistoriaDepartamento());
		
		if(funcionario.getFuncionarioDepartamento() != null) 
			registrarHistoriaDepartamento(funcionario);
		
		return funcionarioRepository.save(funcionario);
	}
	
	private void registrarHistoriaDepartamento(Funcionario funcionario) {
		if(funcionario.getHistoriaDepartamento() == null)
			funcionario.setHistoriaDepartamento(new ArrayList<>());
		
		funcionario.getHistoriaDepartamento().add(funcionario.getFuncionarioDepartamento());
	}
	
	@Transactional
	public void delete(Long id) {
		Funcionario funcionario = funcionarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		funcionarioRepository.delete(funcionario);
	}
	
	public Funcionario findById(Long id) {
		Funcionario funcionario = funcionarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return funcionario;
	}
	
	public List<Funcionario> findAll() {
		return funcionarioRepository.findAll();
	}
	
	public List<Funcionario> listarFuncionariosPorDepartamento(Long idDepartamento){
		return funcionarioRepository.listarFuncionariosPorDepartamento(idDepartamento);
	}
	
}
