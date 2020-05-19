package com.lpi.reserva.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class ReservaDto {

	private Integer idReserva;
	
	private MesaDto mesa;
	
	private ClienteDto cliente;

	private Timestamp dataHora;

	private Boolean ativo;
	
}