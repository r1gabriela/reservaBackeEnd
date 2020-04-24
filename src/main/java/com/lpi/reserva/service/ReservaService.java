package com.lpi.reserva.service;

import com.lpi.reserva.dto.ReservaDto;
import com.lpi.reserva.entity.Reserva;

public interface ReservaService {

	public ReservaDto salvar(ReservaDto reservaDto);
	
	public Reserva preencherReserva(ReservaDto reservaDto);
	
}