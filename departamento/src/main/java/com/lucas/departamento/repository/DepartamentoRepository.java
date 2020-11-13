package com.lucas.departamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.departamento.entity.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{

}
