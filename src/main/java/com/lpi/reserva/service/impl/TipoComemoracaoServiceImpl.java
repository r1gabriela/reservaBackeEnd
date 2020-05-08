package com.lpi.reserva.service.impl;

import java.util.ArrayList;

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
			TipoComemoracao tipocomemoracao = new TipoComemoracao();
			
			tipocomemoracao = tipoComemoracaoRepository.pesquisarDescricao(tipoComemoracaoDto.getDescricao().toLowerCase());
			
			if (tipocomemoracao == null || tipocomemoracao.getIdTipoComemoracao() == tipoComemoracaoDto.getIdTipoComemoracao()){
				tipoComemoracaoRepository.save(preencherTipoComemoracao(tipoComemoracaoDto));		
			} else {
				throw new Exception("Tipo de comemoraçao ja cadastrada");
			}
			return tipoComemoracaoDto;
		} catch(Exception e) {
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
	
	@Override
    public ArrayList<TipoComemoracaoDto> listarTipoComemoracaoDto(Iterable<TipoComemoracao> iterable) {
        ArrayList<TipoComemoracaoDto> listaDto = new ArrayList<>();
        for(TipoComemoracao tipoComemoracao: iterable) 
            listaDto.add(preencherTipoComemoracaoDto(tipoComemoracao));
    
        return listaDto;
    }
	
	@Override
    public ArrayList<TipoComemoracaoDto> listarTodos() {
	    return listarTipoComemoracaoDto(tipoComemoracaoRepository.findAll());
	}
	
	@Override
	public TipoComemoracaoDto pesquisarPorId(int idTipoComemoracao) {	
		return preencherTipoComemoracaoDto(tipoComemoracaoRepository.findById(idTipoComemoracao).get());
	}
	
	@Override
	public TipoComemoracaoDto preencherTipoComemoracaoDto(TipoComemoracao tipoComemoracao) {
		TipoComemoracaoDto tipoComemoracaoDto = new TipoComemoracaoDto();
		tipoComemoracaoDto.setIdTipoComemoracao(tipoComemoracao.getIdTipoComemoracao());
		tipoComemoracaoDto.setDescricao(tipoComemoracao.getDescricao());
		tipoComemoracaoDto.setAtivo(tipoComemoracao.getAtivo());
		return tipoComemoracaoDto;		
	}

	@Override
	public ArrayList<TipoComemoracaoDto> listarPorAtivo() {
		return listarTipoComemoracaoDto(tipoComemoracaoRepository.listarPorAtivo());
	}

}