package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Exception.ExceptionResponse;
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
	
	@Autowired
	private SecurityServiceImpl SecurityService;
	
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
	public ClienteDto pesquisar() {
		return new ModelMapper().map(clienteRepository.findById(pessoaRepository.pesquisarIdPessoaPorLogin(SecurityService.findLoggedInUsername())).get(), ClienteDto.class);
	}
	
	@Override
	public ArrayList<ClienteDto> listarTodos(){
		ArrayList<ClienteDto> clientes = new ArrayList<>();
		Iterable<Cliente> iterable = clienteRepository.findAll();
		
		if (iterable != null)
			clientes = new ModelMapper().map(iterable, new TypeToken<ArrayList<ClienteDto>>() {}.getType());
		
		return clientes;
	}
		
}