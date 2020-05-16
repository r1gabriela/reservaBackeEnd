package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
	public TipoComemoracaoDto salvar(TipoComemoracaoDto tipoComemoracaoDto) {
		try	{
			TipoComemoracao tipocomemoracao = tipoComemoracaoRepository.pesquisarDescricao(tipoComemoracaoDto.getDescricao().toLowerCase());
			
			if (tipocomemoracao == null || tipocomemoracao.getIdTipoComemoracao() == tipoComemoracaoDto.getIdTipoComemoracao()){
				tipocomemoracao = tipoComemoracaoRepository.save(new ModelMapper().map(tipoComemoracaoDto, TipoComemoracao.class));		
			} else {
				throw new Exception("Tipo de comemoraçao ja cadastrada");
			}
			return new ModelMapper().map(tipocomemoracao, TipoComemoracaoDto.class);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}	
	} 
			
	@Override
    public ArrayList<TipoComemoracaoDto> listarTodos() {
	    return new ModelMapper().map(tipoComemoracaoRepository.findAll(), new TypeToken<ArrayList<TipoComemoracaoDto>>() {}.getType());
	}
	
	@Override
	public TipoComemoracaoDto pesquisarPorId(int idTipoComemoracao) {	
		return new ModelMapper().map(tipoComemoracaoRepository.findById(idTipoComemoracao).get(), TipoComemoracaoDto.class);
	}
	
	@Override
	public ArrayList<TipoComemoracaoDto> listarPorAtivo() {
		return new ModelMapper().map(tipoComemoracaoRepository.listarPorAtivo(), new TypeToken<ArrayList<TipoComemoracaoDto>>() {}.getType());
	}

}