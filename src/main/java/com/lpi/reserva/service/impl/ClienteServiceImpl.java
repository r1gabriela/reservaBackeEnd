package com.lpi.reserva.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.ClienteRepository;
import com.lpi.reserva.dto.ClienteDto;
import com.lpi.reserva.entity.Cliente;
import com.lpi.reserva.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@Override
	public ClienteDto salvar(ClienteDto clienteDto) {
		try {
			Cliente cliente = new Cliente();
			
			if (clienteDto.getIdPessoa() == 0) 
				cliente = clienteRepository.pesquisarClientePorCpf(clienteDto.getCpf());
			
			if (cliente == null || cliente.getIdPessoa() == null) {
				clienteRepository.save(preencherCliente(clienteDto));
			} else {
				throw new IllegalArgumentException("Cpf já cadastrado.");
			}
			
			return clienteDto;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}

	@Override
	public Cliente preencherCliente(ClienteDto clienteDto) {
		Cliente cliente = new Cliente();
		cliente.setIdPessoa(clienteDto.getIdPessoa());
		cliente.setNome(clienteDto.getNome());
		cliente.setCpf(clienteDto.getCpf());
		cliente.setEmail(clienteDto.getEmail());
		cliente.setTelefone(clienteDto.getTelefone());
		return cliente;
	}

	@Override
	public ClienteDto pesquisarPorId(int idPessoa) {
		return preencherClienteDto(clienteRepository.findById(idPessoa).get());
	}
	
	@Override
	public ClienteDto preencherClienteDto(Cliente cliente) {
		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setIdPessoa(cliente.getIdPessoa());
		clienteDto.setNome(cliente.getNome());
		clienteDto.setCpf(cliente.getCpf());
		clienteDto.setEmail(cliente.getEmail());
		clienteDto.setTelefone(cliente.getTelefone());
		return clienteDto;
	}
	
}