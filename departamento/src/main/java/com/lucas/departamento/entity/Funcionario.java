package com.lucas.departamento.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "funcionario")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Funcionario implements Serializable {
	private static final long serialVersionUID = -9181544268626873853L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "funcionario_id")
	private Long funcionarioId;
	
	@Column(name = "funcionario_nome", nullable = false, length = 50)
	private String funcionarioNome;
	
	@Column(name = "funcionario_age")
	private int funcionarioAge;
	
	@DateTimeFormat(pattern = "MM/DD/YYYY")
	@Column(name = "funcionario_birthday")
	private Date funcionarioBirthday;
	
	@Column(name = "funcionario_document", length = 50)
	private String funcionarioDocument;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH) 
	@JoinTable(name = "funcionario_departamento" ,  joinColumns = { @JoinColumn(name="funcionario_id")}, 
	inverseJoinColumns = { @JoinColumn(name="departamento_id")})
	private Departamento funcionarioDepartamento;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "historia_departamento" ,  joinColumns = { @JoinColumn(name="funcionario_id")}, 
	inverseJoinColumns = { @JoinColumn(name="departamento_id")})
	private List<Departamento> historiaDepartamento;
	
	
	@JsonCreator
    public Funcionario(
    		@JsonProperty(value = "funcionarioNome", required = true) String funcionarioNome) {
        this.funcionarioNome = funcionarioNome;
    }
	
}
