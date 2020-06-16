package com.lpi.reserva.dto;

import java.sql.Time;
import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class ReservaDto {

	@NotNull(message="{id.not.null}")
	private Integer idReserva;
	
	private MesaDto mesa;
	
	private ClienteDto cliente;

	private Boolean ativo;

	private Time horaEntrada;

	private Time horaSaida;
	
	private Integer capacidade;
	
	private Date dataReserva;
	
}