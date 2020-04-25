package com.lpi.reserva.service.impl;

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
		dataComemorativa.setDatacomemoracao(dataComemorativaDto.getDataComemoracao());
		return dataComemorativa;
	}


	@Override
	public DataComemorativaDto pesquisarPorId(int idDataComemorativa) {
		return preencherDataComemorativaDto(dataComemorativaRepository.findById(idDataComemorativa).get());
	}


	@Override
	public DataComemorativaDto preencherDataComemorativaDto(DataComemorativa dataComemorativa) {
		DataComemorativaDto dataComemorativaDto = new DataComemorativaDto();
		dataComemorativaDto.setIdDataComemorativa(dataComemorativa.getIdDataComemorativa());
		dataComemorativaDto.setIdCliente(dataComemorativa.getCliente().getIdPessoa());
		dataComemorativaDto.setIdPessoa(dataComemorativa.getPessoa().getIdPessoa());
		dataComemorativaDto.setIdTipoComemoracao(dataComemorativa.getTipoComemoracao().getIdTipoComemoracao());
		dataComemorativaDto.setDataComemoracao(dataComemorativa.getDatacomemoracao());
		return dataComemorativaDto;
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

}