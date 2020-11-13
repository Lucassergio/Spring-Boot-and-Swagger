package com.lucas.departamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lucas.departamento.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	@Query(value = "SELECT * FROM funcionario f INNER JOIN funcionario_departamento fd on fd.funcionario_id = f.funcionario_id "
			+ " WHERE fd.departamento_id =:idDepartamento ",  nativeQuery = true)
	List<Funcionario> listarFuncionariosPorDepartamento(@Param("idDepartamento") Long idDepartamento);
}
