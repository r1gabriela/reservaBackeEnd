package com.lpi.reserva.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

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
@Table(name = "reserva")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Reserva implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -960063015908557674L;

	@Id
	@Column(name="idreserva", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idReserva;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="mesa_idmesa", referencedColumnName="idmesa")
	private Mesa mesa;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cliente_pessoa_idpessoa", referencedColumnName="pessoa_idpessoa")
	private Cliente cliente;
	
	@Column(name="datareserva", nullable = false)
    private Date dataReserva;

    @Column(name="horaentrada", nullable = false)
    private Time horaEntrada;

    @Column(name="horasaida", nullable = false)
    private Time horaSaida;
    
	@Column(name="ativo", nullable = false)
	private Boolean ativo;
	
}