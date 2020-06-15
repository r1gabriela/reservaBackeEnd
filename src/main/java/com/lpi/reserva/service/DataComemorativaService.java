package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.DataComemorativaDto;
import com.lpi.reserva.entity.DataComemorativa;

public interface DataComemorativaService {

	public DataComemorativaDto salvar(DataComemorativaDto dataComemorativaDto) throws Exception;
	
	public boolean excluir(DataComemorativa dataComemorativa);
	
	public ArrayList<DataComemorativaDto> listar();
	
}