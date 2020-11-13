package com.lucas.departamento.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "chefe")
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue("Chefe")
public class Chefe extends Funcionario implements Serializable{

	private static final long serialVersionUID = -9001508912492642030L;

	@Column(name = "perfil_chefe", length = 50)
	private String perfilChefe;
	
	@JsonCreator
    public Chefe(
    		@JsonProperty(value = "perfilChefe", required = true) String firstKey) {
        this.perfilChefe = firstKey;
    }

}
