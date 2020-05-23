package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.MesaDto;

public interface MesaService {

	public boolean excluir(MesaDto mesaDto);

	public MesaDto salvar(MesaDto mesaDto);

	public ArrayList<MesaDto> listarTodos();

}