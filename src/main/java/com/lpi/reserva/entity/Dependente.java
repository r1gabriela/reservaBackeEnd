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
@Table(name = "dependente")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
@PrimaryKeyJoinColumn(name="pessoa_idpessoa")
public class Dependente extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6815384046915194863L;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cliente_pessoa_idpessoa", referencedColumnName="pessoa_idpessoa")
	private Cliente cliente;
	
	@Column(name="ativo", nullable = false)
	private Boolean ativo;
	
}
