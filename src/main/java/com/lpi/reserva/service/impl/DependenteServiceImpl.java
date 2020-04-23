package com.lpi.reserva.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.DependenteRepository;
import com.lpi.reserva.dto.DependenteDto;
import com.lpi.reserva.entity.Cliente;
import com.lpi.reserva.entity.Dependente;
import com.lpi.reserva.entity.Pessoa;
import com.lpi.reserva.service.DependenteService;

@Service
public class DependenteServiceImpl implements DependenteService {

	@Autowired
	private DependenteRepository dependenteRepository;
	
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
	public DependenteDto salvar(DependenteDto dependeteDto) {
		try {
			Pessoa pessoa = new Pessoa();
			
			pessoa = pessoaService.pesquisarPorCpf(dependeteDto.getCpf());
			
			if (pessoa == null || pessoa.getIdPessoa() == dependeteDto.getIdPessoa()) {
				dependenteRepository.save(preecherDependente(dependeteDto));
			} else {
				throw new IllegalArgumentException("Cpf já cadastrado.");
			}
			
			return dependeteDto;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}

}