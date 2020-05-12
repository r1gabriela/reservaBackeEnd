package com.lpi.reserva.service;

import java.util.ArrayList;
import java.util.List;

import com.lpi.reserva.dto.PessoaDto;
import com.lpi.reserva.entity.Pessoa;

public interface PessoaService {

	public Pessoa pesquisarPorCpf(String cpf);
	
	public ArrayList<PessoaDto> pesquisarPorNome(String nome);

	public PessoaDto preencherPessoaDto(Pessoa pessoa);

	public ArrayList<PessoaDto> preencherLista(List<Pessoa> pessoas);

}