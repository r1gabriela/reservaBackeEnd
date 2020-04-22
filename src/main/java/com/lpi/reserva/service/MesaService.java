package com.lpi.reserva.service;

import com.lpi.reserva.dto.MesaDto;
import com.lpi.reserva.entity.Mesa;

public interface MesaService {

	public boolean excluir(Integer idMesa);

	public MesaDto salvar(MesaDto mesaDto);
	
	public Mesa preencherMesa(MesaDto mesaDto);	

	public MesaDto pesquisarPorId(int idMesa);

}