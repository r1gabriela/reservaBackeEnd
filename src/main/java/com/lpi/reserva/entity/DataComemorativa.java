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
@Table(name = "DataComemorativa", schema = "reserva.public")
@NoArgsConstructor @AllArgsConstructor
public class DataComemorativa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3747636728874116194L;

	@Id
	@Column(name="idDataComemorativa", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter private Integer idDataComemorativa;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Pessoa_idPessoa", referencedColumnName="idPessoa")
	@Getter @Setter private Pessoa pessoa;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Cliente_Pessoa_idPessoa", referencedColumnName="Pessoa_idPessoa")
	@Getter @Setter private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TipoComemoracao_idTipoComemoracao", referencedColumnName="idTipoComemoracao")
	@Getter @Setter private TipoComemoracao tipoComemoracao;
	
	@Column(name = "data_comemoracao", nullable = false)
	@Getter @Setter private Date datacomemoracao;
	
}
