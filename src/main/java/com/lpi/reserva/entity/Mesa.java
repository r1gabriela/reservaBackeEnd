package com.lpi.reserva.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Mesa", schema = "reserva.public")
@NoArgsConstructor @AllArgsConstructor
public class Mesa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1446424256019791224L;

	@Id
	@Column(name="idMesa", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter private Integer idMesa;
	
	@Column(name="capacidade", nullable = false)
	@Getter @Setter private Integer capacidade;
	
	@Column(name="localizacao", length = 255, nullable = true)
	@Getter @Setter private String localizacao;
	
	@Column(name="ativo", nullable = false)
	@Getter @Setter private Boolean ativo;
	
}
