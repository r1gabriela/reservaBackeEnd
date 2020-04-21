package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.TipoComemoracaoDto;
import com.lpi.reserva.entity.TipoComemoracao;

public interface TipoComemoracaoService {

	public boolean excluir(Integer idTipoComemoracao);
	
	public TipoComemoracaoDto salvar(TipoComemoracaoDto tipoComemoracaoDto);
	
	public TipoComemoracao preencherTipoComemoracao(TipoComemoracaoDto tipoComemoracaoDto);

	public ArrayList<TipoComemoracaoDto> listarTipoComemoracaoDto(Iterable<TipoComemoracao> iterable);

	public ArrayList<TipoComemoracaoDto> listarTodos();
	
}
