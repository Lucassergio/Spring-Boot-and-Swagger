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
@Table(name = "departamento")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Departamento implements Serializable {
	private static final long serialVersionUID = -5093323716411106649L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "departamento_id")
	private Long departamentoId;
	
	@Column(name = "departamento_nome", nullable = false, length = 50)
	private String departamentoNome;
	
	@JsonCreator
    public Departamento(
    		@JsonProperty(value = "departamentoNome", required = true) String departamentoNome) {
        this.departamentoNome = departamentoNome;
    }
	
}
