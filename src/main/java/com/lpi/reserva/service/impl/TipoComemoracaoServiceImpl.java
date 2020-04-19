package com.lpi.reserva.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.TipoComemoracaoRepository;
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

}
