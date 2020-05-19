package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.ClienteRepository;
import com.lpi.reserva.dto.ClienteDto;
import com.lpi.reserva.entity.Cliente;
import com.lpi.reserva.entity.Pessoa;
import com.lpi.reserva.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PessoaServiceImpl pessoaService;
	
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@Override
	public ClienteDto salvar(ClienteDto clienteDto) {
		try {
			Pessoa pessoa = pessoaService.pesquisarPorCpf(clienteDto.getCpf());
			Cliente cliente = new Cliente();
			
			if (pessoa == null || pessoa.getIdPessoa() == clienteDto.getIdPessoa()) {
				cliente = clienteRepository.save(new ModelMapper().map(clienteDto, Cliente.class));
			} else {
				throw new IllegalArgumentException("Cpf já cadastrado.");
			}
			
			return new ModelMapper().map(cliente, ClienteDto.class);
		}catch(Exception e){
			e.printStackTrace();
			return null;
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