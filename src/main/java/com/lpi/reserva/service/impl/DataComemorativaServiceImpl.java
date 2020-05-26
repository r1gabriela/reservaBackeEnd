package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Exception.ExceptionResponse;
import com.lpi.reserva.Repository.DataComemorativaRepository;
import com.lpi.reserva.Repository.PessoaRepository;
import com.lpi.reserva.dto.ClienteDto;
import com.lpi.reserva.dto.DataComemorativaDto;
import com.lpi.reserva.entity.DataComemorativa;
import com.lpi.reserva.service.DataComemorativaService;

@Service
public class DataComemorativaServiceImpl implements  DataComemorativaService {

	@Autowired
	private DataComemorativaRepository dataComemorativaRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private SecurityServiceImpl securityServiceImpl;

	public DataComemorativaServiceImpl(DataComemorativaRepository dataComemorativaRepository) {
		this.dataComemorativaRepository = dataComemorativaRepository;
	}
	
	
	@Override
	public DataComemorativaDto salvar(DataComemorativaDto dataComemorativaDto) throws Exception, ExceptionResponse {
		try {
			DataComemorativa dataComemorativa = new DataComemorativa();
			
			ClienteDto clienteDto = new ClienteDto();
			clienteDto.setIdPessoa(pessoaRepository.pesquisarIdPessoaPorLogin(securityServiceImpl.findLoggedInUsername()));
			dataComemorativaDto.setCliente(clienteDto);
			
			dataComemorativa = dataComemorativaRepository.pesquisarDataComemorativaRepetidada(dataComemorativaDto.getCliente().getIdPessoa(), dataComemorativaDto.getPessoa().getIdPessoa(), dataComemorativaDto.getTipoComemoracao().getIdTipoComemoracao());
			
			if (dataComemorativa == null || dataComemorativa.getIdDataComemorativa() == dataComemorativaDto.getIdDataComemorativa()) {
				dataComemorativa = dataComemorativaRepository.save(new ModelMapper().map(dataComemorativaDto, DataComemorativa.class));
			} else {
				throw new ExceptionResponse("Data Comemorativa já cadastrada para pessoa selecionada.");
			}
			
			return new ModelMapper().map(dataComemorativa, DataComemorativaDto.class);
		} catch(ExceptionResponse ex) {
			throw new ExceptionResponse(ex.getMessage());
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
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


	@Override
	public ArrayList<DataComemorativaDto> listar() {
		return new ModelMapper().map(dataComemorativaRepository.findAllCliente(pessoaRepository.pesquisarIdPessoaPorLogin(securityServiceImpl.findLoggedInUsername())), new TypeToken<ArrayList<DataComemorativaDto>>() {}.getType());
	}

}