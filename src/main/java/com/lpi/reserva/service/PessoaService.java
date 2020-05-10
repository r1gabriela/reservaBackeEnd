package com.lpi.reserva.service;

import com.lpi.reserva.dto.PessoaDto;
import com.lpi.reserva.entity.Pessoa;

public interface PessoaService {

	public Pessoa pesquisarPorCpf(String cpf);
	
	public Pessoa pesquisarPorNome(String nome);

	public PessoaDto preencherPessoaDto(Pessoa pessoa);

}