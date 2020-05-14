package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.ClienteRepository;
import com.lpi.reserva.Repository.DependenteRepository;
import com.lpi.reserva.dto.DependenteDto;
import com.lpi.reserva.dto.PessoaDto;
import com.lpi.reserva.entity.Cliente;
import com.lpi.reserva.entity.Dependente;
import com.lpi.reserva.entity.Pessoa;
import com.lpi.reserva.service.DependenteService;

@Service
public class DependenteServiceImpl implements DependenteService {

	@Autowired
	private DependenteRepository dependenteRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PessoaServiceImpl pessoaService;
	
	public DependenteServiceImpl(DependenteRepository dependenteRepository) {
		this.dependenteRepository = dependenteRepository;
	}
		
	public Dependente preecherDependente(DependenteDto dependenteDto) {
		Dependente dependente = new Dependente();
		dependente.setIdPessoa(dependenteDto.getIdPessoa());
		dependente.setNome(dependenteDto.getNome());
		dependente.setCpf(dependenteDto.getCpf());
		Cliente cliente = new Cliente();
		cliente.setIdPessoa(dependenteDto.getIdCliente());
		dependente.setCliente(cliente);
		dependente.setAtivo(dependenteDto.isAtivo());
		return dependente;
	}
	
	@Override
	public DependenteDto salvar(DependenteDto dependenteDto) {
		try {
			Pessoa pessoa = new Pessoa();
			
			pessoa = pessoaService.pesquisarPorCpf(dependenteDto.getCpf());
			
			if (pessoa == null || pessoa.getIdPessoa() == dependenteDto.getIdPessoa()) {
				dependenteRepository.save(preecherDependente(dependenteDto));
			} else {
				throw new IllegalArgumentException("Cpf já cadastrado.");
			}
			
			return dependenteDto;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}

	@Override	
	public boolean excluir(Integer idPessoa) {
		try {
			Dependente dependente = dependenteRepository.findById(idPessoa).get();
			dependente.setAtivo(false);
			dependenteRepository.save(dependente);
			return true;
		}catch(Exception e){
		     e.printStackTrace(); 
		     return false;
		}
	}
	
	@Override
	public ArrayList<PessoaDto> listarPessoas(Cliente cliente) {
		ArrayList<PessoaDto> listaDto = new ArrayList<>();
		for(Dependente dependente: cliente.getDependente())
			listaDto.add(pessoaService.preencherPessoaDto(dependente));
		
			listaDto.add(pessoaService.preencherPessoaDto(cliente));
		
		return listaDto;
	}
	
	@Override
	public ArrayList<PessoaDto> listarPessoasDeCliente(int idCliente){
		return listarPessoas(clienteRepository.pesquisarClientePorId(idCliente));
	}

	@Override
	public DependenteDto preencherDependenteDto(Dependente dependente) {
		DependenteDto dependenteDto = new DependenteDto();
		dependenteDto.setIdPessoa(dependente.getIdPessoa());
		dependenteDto.setNome(dependente.getNome());
		dependenteDto.setCpf(dependente.getCpf());
		Cliente cliente = new Cliente();
		cliente.setIdPessoa(dependenteDto.getIdCliente());
		dependente.setCliente(cliente);
		dependente.setAtivo(dependenteDto.isAtivo());
		return dependenteDto;
		
	}
	
} 