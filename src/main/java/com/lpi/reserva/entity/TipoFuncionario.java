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
@Table(name = "tipofuncionario")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class TipoFuncionario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4657118136178797375L;

	@Id
	@Column(name="idtipofuncionario", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTipoFuncionario;
	
	@Column(name="descricao", length = 255, nullable = true)
	private String descricao;
	
	@Column(name="ativo", nullable = false)
	private Boolean ativo;
	
}
