package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.ClienteDto;

public interface ClienteService {

	public ClienteDto salvar(ClienteDto clienteDto);

	public ClienteDto pesquisarPorId(int idPessoa);

	public ArrayList<ClienteDto> listarTodos();
	
}