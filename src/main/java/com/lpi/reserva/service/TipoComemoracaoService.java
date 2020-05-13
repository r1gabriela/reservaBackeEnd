package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.TipoComemoracaoDto;
import com.lpi.reserva.entity.TipoComemoracao;

public interface TipoComemoracaoService {

	public boolean excluir(TipoComemoracaoDto tipoComemoracaoDto);
	
	public TipoComemoracaoDto salvar(TipoComemoracaoDto tipoComemoracaoDto);
	
	public TipoComemoracao preencherTipoComemoracao(TipoComemoracaoDto tipoComemoracaoDto);

	public ArrayList<TipoComemoracaoDto> listarTipoComemoracaoDto(Iterable<TipoComemoracao> iterable);

	public ArrayList<TipoComemoracaoDto> listarTodos();

	public TipoComemoracaoDto pesquisarPorId(int idTipoComemoracao);

	public TipoComemoracaoDto preencherTipoComemoracaoDto(TipoComemoracao tipoComemoracao);

	public ArrayList<TipoComemoracaoDto> listarPorAtivo();
	
}