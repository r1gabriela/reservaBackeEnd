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
@Table(name = "mesa")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Mesa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1446424256019791224L;

	@Id
	@Column(name="idmesa", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMesa;
	
	@Column(name="capacidade", nullable = false)
	private Integer capacidade;
	
	@Column(name="localizacao", length = 255, nullable = true)
	private String localizacao;
	
	@Column(name="ativo", nullable = false)
	private Boolean ativo;
	
}
