package com.lpi.reserva.service;

import com.lpi.reserva.dto.ReservaDto;

public interface ReservaService {

	public ReservaDto salvar(ReservaDto reservaDto);
	
	public boolean excluir(int idReserva);
	
}