package com.lpi.reserva.service;

import com.lpi.reserva.dto.DataComemorativaDto;
import com.lpi.reserva.entity.DataComemorativa;

public interface DataComemorativaService {

	public DataComemorativaDto salvar(DataComemorativaDto dataComemorativaDto);
	
	public DataComemorativa preencherDataComemorativa(DataComemorativaDto dataComemorativaDto);
	
	public DataComemorativaDto pesquisarPorId(int idDataComemorativa);
	
	public DataComemorativaDto preencherDataComemorativaDto(DataComemorativa dataComemorativa);
	
}