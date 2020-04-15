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
@Table(name = "Usuario", schema = "reserva.public")
@NoArgsConstructor @AllArgsConstructor
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6018189950559272348L;

	@Id
	@Column(name="idUsuario", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter private Integer idUsuario;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Pessoa_idPessoa", referencedColumnName="idPessoa")
	@Getter @Setter private Pessoa pessoa;
	
	@Column(name="login", length = 8, nullable = false)
	@Getter @Setter private String login;
	
	@Column(name="senha", length = 255, nullable = false)
	@Getter @Setter private String senha;
	
	@Column(name="ativo", nullable = false)
	@Getter @Setter private Boolean ativo;
	
}
