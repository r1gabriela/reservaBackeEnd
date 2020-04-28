package com.lpi.reserva.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6018189950559272348L;

	@Id
	@Column(name="idusuario", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pessoa_idpessoa", referencedColumnName="idpessoa")
	private Pessoa pessoa;
	
	@Column(name="login", length = 8, nullable = false)
	private String login;
	
	@Column(name="senha", length = 255, nullable = false)
	private String senha;
	
	@Column(name="ativo", nullable = false)
	private Boolean ativo;
	
}
