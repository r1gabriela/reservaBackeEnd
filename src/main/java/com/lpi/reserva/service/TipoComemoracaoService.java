package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.TipoComemoracaoDto;

public interface TipoComemoracaoService {

	public boolean excluir(TipoComemoracaoDto tipoComemoracaoDto);
	
	public TipoComemoracaoDto salvar(TipoComemoracaoDto tipoComemoracaoDto) throws Exception;

	public ArrayList<TipoComemoracaoDto> listarTodos();

	public TipoComemoracaoDto pesquisarPorId(int idTipoComemoracao);

	public ArrayList<TipoComemoracaoDto> listarPorAtivo();
	
}