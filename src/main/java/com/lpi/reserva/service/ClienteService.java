package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.ClienteDto;

public interface ClienteService {

	public ClienteDto salvar(ClienteDto clienteDto) throws Exception;

	public ClienteDto pesquisar();

	public ArrayList<ClienteDto> listarTodos();

	public ArrayList<ClienteDto> listarPorCpf(String cpf);
	
}