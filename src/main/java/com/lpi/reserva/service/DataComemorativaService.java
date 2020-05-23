package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.DataComemorativaDto;

public interface DataComemorativaService {

	public DataComemorativaDto salvar(DataComemorativaDto dataComemorativaDto) throws Exception;
	
	public DataComemorativaDto pesquisarPorId(int idDataComemorativa);
	
	public boolean excluir(int idDataComemorativa);
	
	public ArrayList<DataComemorativaDto> pesquisarPorIdTipoComemoracao(int idTipoComemoracao);
	
	public ArrayList<DataComemorativaDto> listar();
	
}