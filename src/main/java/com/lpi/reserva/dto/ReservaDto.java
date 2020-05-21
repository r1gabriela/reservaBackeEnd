package com.lpi.reserva.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class ReservaDto {

	@NotBlank(message="{id.not.null}")
	private Integer idReserva;
	
	@NotBlank
	private MesaDto mesa;
	
	@NotBlank
	private ClienteDto cliente;

	@NotBlank
	private Timestamp dataHora;

	private Boolean ativo;
	
}