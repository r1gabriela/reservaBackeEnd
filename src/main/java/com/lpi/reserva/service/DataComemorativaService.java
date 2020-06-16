package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.DataComemorativaDto;

public interface DataComemorativaService {

	public DataComemorativaDto salvar(DataComemorativaDto dataComemorativaDto) throws Exception;
	
	public boolean excluir(DataComemorativaDto dataComemorativaDto);
	
	public ArrayList<DataComemorativaDto> listar();
	
}