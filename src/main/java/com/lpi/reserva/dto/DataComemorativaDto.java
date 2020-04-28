package com.lpi.reserva.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class DataComemorativaDto {

	private Integer idDataComemorativa;

	private Integer IdPessoa;

	private Integer idCliente;
	
	private Integer idTipoComemoracao;
	
	private Date dataComemoracao;
	
}