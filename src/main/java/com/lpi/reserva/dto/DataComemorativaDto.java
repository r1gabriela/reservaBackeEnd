package com.lpi.reserva.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class DataComemorativaDto {

	@NotNull(message= "{id.not.null}")
	private Integer idDataComemorativa;

	@NotBlank
	private PessoaDto pessoa;

	@NotBlank
	private ClienteDto cliente;
	
	@NotBlank
	private TipoComemoracaoDto tipoComemoracao;
	
	@NotBlank(message = "{data.not.blank}")
	private Date datacomemoracao;
	
}