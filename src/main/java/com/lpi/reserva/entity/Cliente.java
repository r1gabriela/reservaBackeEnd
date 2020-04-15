package com.lpi.reserva.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cliente", schema = "reserva.public")
@NoArgsConstructor @AllArgsConstructor
@PrimaryKeyJoinColumn(name="Pessoa_idPessoa")
public class Cliente extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7566674233417885499L;

	@Column(name = "telefone", length = 11, nullable = false)
	@Getter @Setter private String telefone;
	
	@Column(name = "email", length = 255, nullable = false)
	@Getter @Setter private String email;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Reserva> reservas;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Dependente> dependente;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<DataComemorativa> datasComemorativas;
	
}
