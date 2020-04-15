package com.lpi.reserva.entity;

import java.io.Serializable;
import java.sql.Timestamp;

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
@Table(name = "Reserva", schema = "reserva.public")
@NoArgsConstructor @AllArgsConstructor
public class Reserva implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -960063015908557674L;

	@Id
	@Column(name="idReserva", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter private Integer idReserva;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Mesa_idMesa", referencedColumnName="idMesa")
	@Getter @Setter private Mesa mesa;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Cliente_Pessoa_idPessoa", referencedColumnName="Pessoa_idPessoa")
	@Getter @Setter private Cliente cliente;
	
	@Column(name = "dataHora", nullable = false)
	@Getter @Setter private Timestamp dataHora;
	
	@Column(name="ativo", nullable = false)
	@Getter @Setter private Boolean ativo;
	
}
