package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.DataComemorativaRepository;
import com.lpi.reserva.dto.DataComemorativaDto;
import com.lpi.reserva.entity.DataComemorativa;
import com.lpi.reserva.service.DataComemorativaService;

@Service
public class DataComemorativaServiceImpl implements  DataComemorativaService {

	@Autowired
	private DataComemorativaRepository dataComemorativaRepository;

	public DataComemorativaServiceImpl(DataComemorativaRepository dataComemorativaRepository) {
		this.dataComemorativaRepository = dataComemorativaRepository;
	}
	
	
	@Override
	public DataComemorativaDto salvar(DataComemorativaDto dataComemorativaDto) {
		try {
			DataComemorativa dataComemorativa = new DataComemorativa();
			
			dataComemorativa = dataComemorativaRepository.pesquisarDataComemorativaRepetidada(dataComemorativaDto.getCliente().getIdPessoa(), dataComemorativaDto.getPessoa().getIdPessoa(), dataComemorativaDto.getTipoComemoracao().getIdTipoComemoracao());
			
			if (dataComemorativa == null || dataComemorativa.getIdDataComemorativa() == dataComemorativaDto.getIdDataComemorativa()) {
				dataComemorativa = dataComemorativaRepository.save(new ModelMapper().map(dataComemorativaDto, DataComemorativa.class));
			} else {
				throw new IllegalArgumentException("Data Comemorativa já cadastrada para pessoa selecionada.");
			}
			
			return new ModelMapper().map(dataComemorativa, DataComemorativaDto.class);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}

	@Override
	public DataComemorativaDto pesquisarPorId(int idDataComemorativa) {
		return new ModelMapper().map(dataComemorativaRepository.findById(idDataComemorativa).get(), DataComemorativaDto.class);
	}

	@Override
	public boolean excluir(int idDataComemorativa) {
		try {
			dataComemorativaRepository.deleteById(idDataComemorativa);;
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public ArrayList<DataComemorativaDto> pesquisarPorIdTipoComemoracao(int idTipoComemoracao) {
		return new ModelMapper().map(dataComemorativaRepository.pesquisarPorIdTipoComemoracao(idTipoComemoracao), new TypeToken<ArrayList<DataComemorativaDto>>() {}.getType());
	}

}