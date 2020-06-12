package com.lpi.reserva.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class MesaDto {
	
	@NotNull(message= "{id.not.null}")
	private Integer idMesa;
	
	@NotNull(message= "{capacidade.not.blank}")
	private Integer capacidade;
	
	private String localizacao;
	
	private Boolean ativo;
	
}