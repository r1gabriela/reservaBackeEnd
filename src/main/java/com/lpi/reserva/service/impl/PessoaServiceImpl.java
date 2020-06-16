package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.PessoaRepository;
import com.lpi.reserva.dto.PessoaDto;
import com.lpi.reserva.entity.Pessoa;
import com.lpi.reserva.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public PessoaServiceImpl(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	@Override
	public Pessoa pesquisarPorCpf(String cpf) {
		return pessoaRepository.pesquisarPorCpf(cpf);
	}

	@Override
	public ArrayList<PessoaDto> pesquisarPorNome(String nome) {
		return new ModelMapper().map(pessoaRepository.pesquisarPorNome(nome.toLowerCase()), new TypeToken<ArrayList<PessoaDto>>() {}.getType());
	}
	
}