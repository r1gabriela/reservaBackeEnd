package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.FuncionarioDto;

public interface FuncionarioService {

	public FuncionarioDto salvar(FuncionarioDto funcionarioDto);
	
	public FuncionarioDto pesquisarPorId(int idPessoa);

	public ArrayList<FuncionarioDto> listarTodos();
	
}