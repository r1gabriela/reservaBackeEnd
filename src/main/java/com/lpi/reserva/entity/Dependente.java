package com.lpi.reserva.entity;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "Dependente", schema = "reserva.public")
@NoArgsConstructor @AllArgsConstructor
@PrimaryKeyJoinColumn(name="Pessoa_idPessoa")
public class Dependente extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6815384046915194863L;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Cliente_Pessoa_idPessoa", referencedColumnName="Pessoa_idPessoa")
	@Getter @Setter private Cliente cliente;
	
	@Column(name="ativo", nullable = false)
	@Getter @Setter private Boolean ativo;
	
}
