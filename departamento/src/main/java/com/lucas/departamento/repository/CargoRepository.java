package com.lucas.departamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.departamento.entity.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long>{

}
