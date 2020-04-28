package com.lpi.reserva.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class ReservaDto {

	private Integer idReserva;
	
	private Integer idMesa;
	
	private Integer idCliente;

	private String dataHora;

	private Boolean ativo;
	
}