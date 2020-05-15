package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.FuncionarioDto;
import com.lpi.reserva.entity.Funcionario;

public interface FuncionarioService {

	public FuncionarioDto salvar(FuncionarioDto funcionarioDto);
	
	public Funcionario preencherFuncionario(FuncionarioDto funcionarioDto);

	public FuncionarioDto pesquisarPorId(int idPessoa);

	public FuncionarioDto preencherFuncionarioDto(Funcionario funcionario);

	public ArrayList<FuncionarioDto> listarTodos();

	public ArrayList<FuncionarioDto> listaDto(Iterable<Funcionario> funcionarios);	
	
}