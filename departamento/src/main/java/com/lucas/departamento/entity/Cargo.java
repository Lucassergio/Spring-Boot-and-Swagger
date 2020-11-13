package com.lucas.departamento.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cargo")
@Getter
@Setter
@ToString
@NoArgsConstructor	
@AllArgsConstructor
@EqualsAndHashCode
public class Cargo implements Serializable{
	private static final long serialVersionUID = 3127917286248583307L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cargo_id")
	private Long cargoId;
	
	@Column(name = "cargo_nome", nullable = false, length = 50)
	private String cargoNome;
	
	@JsonCreator
    public Cargo(
    		@JsonProperty(value = "cargoNome", required = true) String cargoNome) {
        this.cargoNome = cargoNome;
    }

}
