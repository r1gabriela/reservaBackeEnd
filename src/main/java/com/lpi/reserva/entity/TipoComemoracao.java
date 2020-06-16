package com.lpi.reserva.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipocomemoracao", schema = "public")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class TipoComemoracao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5943350777755695569L;

	@Id
	@Column(name="idtipocomemoracao", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTipoComemoracao;
	
	@Column(name = "descricao", length = 255, nullable = false)
	private String descricao;
	
	@Column(name="ativo", nullable = false)
	private Boolean ativo;

}