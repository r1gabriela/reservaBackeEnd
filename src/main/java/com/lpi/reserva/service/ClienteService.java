package com.lpi.reserva.service;

import com.lpi.reserva.dto.ClienteDto;
import com.lpi.reserva.entity.Cliente;

public interface ClienteService {

	public ClienteDto salvar(ClienteDto clienteDto);

	public Cliente preencherCliente(ClienteDto clienteDto);

	public ClienteDto pesquisarPorId(int idPessoa);

	public ClienteDto preencherClienteDto(Cliente cliente);
	
}