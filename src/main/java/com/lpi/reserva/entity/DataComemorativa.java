package com.lpi.reserva.entity;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "datacomemorativa")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class DataComemorativa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3747636728874116194L;

	@Id
	@Column(name="iddatacomemorativa", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idDataComemorativa;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pessoa_idpessoa", referencedColumnName="idpessoa")
	private Pessoa pessoa;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cliente_pessoa_idpessoa", referencedColumnName="pessoa_idpessoa")
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tipocomemoracao_idtipocomemoracao", referencedColumnName="idtipocomemoracao")
	private TipoComemoracao tipoComemoracao;
	
	@Column(name = "data_comemoracao", nullable = false)
	private Date datacomemoracao;
	
}