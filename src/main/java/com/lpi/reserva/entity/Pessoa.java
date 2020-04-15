package com.lpi.reserva.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Pessoa", schema = "reserva.public")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor @AllArgsConstructor
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3793203373817358069L;

	@Id
	@Column(name="idPessoa", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter private Integer idPessoa;
	
	@Column(name = "nome", length = 255, nullable = false)
	@Getter @Setter private String nome;
	
	@Column(name = "cpf", length = 11, nullable = false)
	@Getter @Setter private String cpf;
	
}
