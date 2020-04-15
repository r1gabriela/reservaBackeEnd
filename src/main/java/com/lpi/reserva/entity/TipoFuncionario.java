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
@Table(name = "TipoFuncionario", schema = "reserva.public")
@NoArgsConstructor @AllArgsConstructor
public class TipoFuncionario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4657118136178797375L;

	@Id
	@Column(name="idTipoFuncionario", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter private Integer idTipoFuncionario;
	
	@Column(name="descricao", length = 255, nullable = true)
	@Getter @Setter private String descricao;
	
	@Column(name="ativo", nullable = false)
	@Getter @Setter private Boolean ativo;
	
}
