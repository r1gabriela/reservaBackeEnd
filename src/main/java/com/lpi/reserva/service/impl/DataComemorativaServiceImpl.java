package com.lpi.reserva.service.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.DataComemorativaRepository;
import com.lpi.reserva.dto.DataComemorativaDto;
import com.lpi.reserva.entity.Cliente;
import com.lpi.reserva.entity.DataComemorativa;
import com.lpi.reserva.entity.Pessoa;
import com.lpi.reserva.entity.TipoComemoracao;
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
			
			dataComemorativa = dataComemorativaRepository.pesquisarDataComemorativaRepetidada(dataComemorativaDto.getIdCliente(), dataComemorativaDto.getIdPessoa(), dataComemorativaDto.getIdTipoComemoracao());
			
			if (dataComemorativa == null || dataComemorativa.getIdDataComemorativa() == dataComemorativaDto.getIdDataComemorativa()) {
				dataComemorativaRepository.save(preencherDataComemorativa(dataComemorativaDto));
			} else {
				throw new IllegalArgumentException("Data Comemorativa já cadastrada para pessoa selecionada.");
			}
			
			return dataComemorativaDto;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}


	@Override
	public DataComemorativa preencherDataComemorativa(DataComemorativaDto dataComemorativaDto) {
		DataComemorativa dataComemorativa = new DataComemorativa();
		dataComemorativa.setIdDataComemorativa(dataComemorativaDto.getIdDataComemorativa());
		Cliente cliente = new Cliente();
		cliente.setIdPessoa(dataComemorativaDto.getIdCliente());
		dataComemorativa.setCliente(cliente);
		Pessoa pessoa = new Pessoa();
		pessoa.setIdPessoa(dataComemorativaDto.getIdPessoa());
		dataComemorativa.setPessoa(pessoa);
		TipoComemoracao tipoComemoracao = new TipoComemoracao();
		tipoComemoracao.setIdTipoComemoracao(dataComemorativaDto.getIdTipoComemoracao());
		dataComemorativa.setTipoComemoracao(tipoComemoracao);
//		long time = Long.parseLong(dataComemorativaDto.getDataComemoracao());
//		Date date = new Date(time);
		dataComemorativa.setDatacomemoracao(dataComemorativaDto.getDataComemoracao());
		return dataComemorativa;
	}

}