package com.lpi.reserva.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.TipoComemoracaoRepository;
import com.lpi.reserva.dto.TipoComemoracaoDto;
import com.lpi.reserva.entity.TipoComemoracao;
import com.lpi.reserva.service.TipoComemoracaoService;

@Service
public class TipoComemoracaoServiceImpl implements TipoComemoracaoService {

	@Autowired
	private TipoComemoracaoRepository tipoComemoracaoRepository;
	
	public TipoComemoracaoServiceImpl(TipoComemoracaoRepository tipoComemoracaoRepository) {
	this.tipoComemoracaoRepository = tipoComemoracaoRepository;
	}

	@Override
	public boolean excluir(Integer idTipoComemoracao) {
		try {
			TipoComemoracao tipoComemoracao = tipoComemoracaoRepository.findById(idTipoComemoracao).get();
			tipoComemoracao.setAtivo(false);
			tipoComemoracaoRepository.save(tipoComemoracao);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public TipoComemoracaoDto salvar(TipoComemoracaoDto tipoComemoracaoDto) {
		try	{
			tipoComemoracaoRepository.save(preencherTipoComemoracao(tipoComemoracaoDto));
			return tipoComemoracaoDto;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
		
	} 
	
	@Override
	public TipoComemoracao preencherTipoComemoracao(TipoComemoracaoDto tipoComemoracaoDto) {
		TipoComemoracao tipoComemoracao = new TipoComemoracao();
		tipoComemoracao.setIdTipoComemoracao(tipoComemoracaoDto.getIdTipoComemoracao()); 
		tipoComemoracao.setDescricao(tipoComemoracaoDto.getDescricao());
		tipoComemoracao.setAtivo(tipoComemoracaoDto.getAtivo());
		return tipoComemoracao;
	}		
	
}


