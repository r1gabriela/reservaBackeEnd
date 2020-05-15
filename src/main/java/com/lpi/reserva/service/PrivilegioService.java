package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.PrivilegioDto;
import com.lpi.reserva.entity.Privilegio;


public interface PrivilegioService {
	
	
	public ArrayList<PrivilegioDto> salvar(ArrayList<PrivilegioDto> privilegioDto);

	public Privilegio preencherPrivilegio(PrivilegioDto privilegioDto);

	public ArrayList<Privilegio> preencherLista(ArrayList<PrivilegioDto> privilegio);
	
}
 