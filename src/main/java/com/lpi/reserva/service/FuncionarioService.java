package com.lpi.reserva.service;

import com.lpi.reserva.dto.FuncionarioDto;
import com.lpi.reserva.entity.Funcionario;

public interface FuncionarioService {

	public FuncionarioDto salvar(FuncionarioDto funcionarioDto);
	
	public Funcionario preencherFuncionario(FuncionarioDto funcionarioDto);	
	
}