package com.lpi.reserva.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Funcionario", schema = "reserva.public")
@NoArgsConstructor @AllArgsConstructor
@PrimaryKeyJoinColumn(name="Pessoa_idPessoa")
public class Funcionario extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4934934335567256816L;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TipoFuncionario_idTipoFuncionario", referencedColumnName="idTipoFuncionario")
	@Getter @Setter private TipoFuncionario tipoFuncionario;
	
}
