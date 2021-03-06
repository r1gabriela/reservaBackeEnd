package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Exception.ExceptionResponse;
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
	public boolean excluir(TipoComemoracaoDto tipoComemoracaoDto) {
		try {
			tipoComemoracaoDto.setAtivo(false);
			tipoComemoracaoRepository.save(new ModelMapper().map(tipoComemoracaoDto, TipoComemoracao.class));
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public TipoComemoracaoDto salvar(TipoComemoracaoDto tipoComemoracaoDto) throws Exception, ExceptionResponse {
		try	{
			TipoComemoracao tipocomemoracao = tipoComemoracaoRepository.pesquisarDescricao(tipoComemoracaoDto.getDescricao().toLowerCase());
			
			if (tipocomemoracao == null || tipocomemoracao.getIdTipoComemoracao() == tipoComemoracaoDto.getIdTipoComemoracao()){
				tipoComemoracaoDto.setAtivo(true);
				tipocomemoracao = tipoComemoracaoRepository.save(new ModelMapper().map(tipoComemoracaoDto, TipoComemoracao.class));		
			} else {
				throw new ExceptionResponse("Tipo de comemoração já cadastrado");
		
			}
			return new ModelMapper().map(tipocomemoracao, TipoComemoracaoDto.class);
		} catch(ExceptionResponse ex) {
			throw new ExceptionResponse(ex.getMessage());
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	} 
			
	@Override
    public ArrayList<TipoComemoracaoDto> listarTodos() {
		ArrayList<TipoComemoracaoDto> tipos = new ArrayList<>();
		Iterable<TipoComemoracao> iterable = tipoComemoracaoRepository.findAll();
		
		if (iterable != null)
			tipos = new ModelMapper().map(iterable, new TypeToken<ArrayList<TipoComemoracaoDto>>() {}.getType());
		
	    return tipos;
	}
	
	@Override
	public ArrayList<TipoComemoracaoDto> listarPorAtivo() {
		ArrayList<TipoComemoracaoDto> tipos = new ArrayList<>();
		Iterable<TipoComemoracao> iterable = tipoComemoracaoRepository.listarPorAtivo();
		
		if (iterable != null)
			tipos = new ModelMapper().map(iterable, new TypeToken<ArrayList<TipoComemoracaoDto>>() {}.getType());
		
	    return tipos;
	}

}