package com.lucas.departamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.departamento.entity.Chefe;

@Repository
public interface ChefeRepository extends JpaRepository<Chefe, Long>{

}
