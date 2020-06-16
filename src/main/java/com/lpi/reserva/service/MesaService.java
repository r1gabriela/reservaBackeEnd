package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.MesaDto;
import com.lpi.reserva.dto.ReservaDto;

public interface MesaService {

	public boolean excluir(MesaDto mesaDto);

	public MesaDto salvar(MesaDto mesaDto);

	public ArrayList<MesaDto> listarTodos();
	
	public ArrayList<MesaDto> verDisponibilidadeMesa(ReservaDto reservaDto);

}