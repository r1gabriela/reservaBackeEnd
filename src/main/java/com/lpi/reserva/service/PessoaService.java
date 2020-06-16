package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.PessoaDto;
import com.lpi.reserva.entity.Pessoa;

public interface PessoaService {

	public Pessoa pesquisarPorCpf(String cpf);
	
	public ArrayList<PessoaDto> pesquisarPorNome(String nome);

	public ArrayList<PessoaDto> pesquisarUsuarioNaoCadastradoPorCpf(String cpf);

}