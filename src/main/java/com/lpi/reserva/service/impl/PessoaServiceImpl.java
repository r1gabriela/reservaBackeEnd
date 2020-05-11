package com.lpi.reserva.service.impl;

import java.util.ArrayList;
import java.util.List;

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
		return preencherLista(pessoaRepository.pesquisarPorNome(nome.toLowerCase()));
	}
	
	@Override
	public PessoaDto preencherPessoaDto(Pessoa pessoa) {
		PessoaDto pessoaDto = new PessoaDto();
		pessoaDto.setIdPessoa(pessoa.getIdPessoa());
		pessoaDto.setCpf(pessoa.getCpf());
		pessoaDto.setNome(pessoa.getNome());
		return pessoaDto;
	}
	
	@Override
	public ArrayList<PessoaDto> preencherLista(List<Pessoa> pessoas){
		ArrayList<PessoaDto> listaPessoaDto = new ArrayList<>(); 
		for (Pessoa pessoa : pessoas) 
			listaPessoaDto.add(preencherPessoaDto(pessoa));
		
		return listaPessoaDto;
	}
	
}