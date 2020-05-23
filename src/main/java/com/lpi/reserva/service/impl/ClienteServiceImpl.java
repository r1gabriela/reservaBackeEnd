package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Errors.ExceptionResponse;
import com.lpi.reserva.Repository.ClienteRepository;
import com.lpi.reserva.Repository.PessoaRepository;
import com.lpi.reserva.dto.ClienteDto;
import com.lpi.reserva.entity.Cliente;
import com.lpi.reserva.entity.Pessoa;
import com.lpi.reserva.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
		
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@Override
	public ClienteDto salvar(ClienteDto clienteDto) throws Exception, ExceptionResponse {
		try {
			Pessoa pessoa = pessoaRepository.pesquisarPorCpf(clienteDto.getCpf());
			Cliente cliente = new Cliente();
			
			if (pessoa == null || pessoa.getIdPessoa() == clienteDto.getIdPessoa()) {
				cliente = clienteRepository.save(new ModelMapper().map(clienteDto, Cliente.class));
			} else {
				throw new ExceptionResponse("Cpf já cadastrado.");
			}
			
			return new ModelMapper().map(cliente, ClienteDto.class);
		} catch(ExceptionResponse ex) {
			throw new ExceptionResponse(ex.getMessage());
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public ClienteDto pesquisarPorId(int idPessoa) {
		return new ModelMapper().map(clienteRepository.findById(idPessoa).get(), ClienteDto.class);
	}
	
	@Override
	public ArrayList<ClienteDto> listarTodos(){
		return new ModelMapper().map(clienteRepository.findAll(), new TypeToken<ArrayList<ClienteDto>>() {}.getType());
	}
		
}