package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
		
	@Override
	public DependenteDto salvar(DependenteDto dependenteDto) {
		try {
			Pessoa pessoa = pessoaService.pesquisarPorCpf(dependenteDto.getCpf());
			Dependente dependente = new Dependente();
			
			if (pessoa == null || pessoa.getIdPessoa() == dependenteDto.getIdPessoa()) {
				dependente = dependenteRepository.save(new ModelMapper().map(dependenteDto, Dependente.class));
			} else {
				throw new IllegalArgumentException("Cpf já cadastrado.");
			}
			
			return new ModelMapper().map(dependente, DependenteDto.class);
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
		
		listaDto = new ModelMapper().map(cliente.getDependente(), new TypeToken<ArrayList<PessoaDto>>() {}.getType());
		listaDto.add(new ModelMapper().map(cliente, PessoaDto.class));
		
		return listaDto;
	}
	
	@Override
	public ArrayList<PessoaDto> listarPessoasDeCliente(int idCliente){
		return listarPessoas(clienteRepository.pesquisarClientePorId(idCliente));
	}

//	@Override
//	public ArrayList<DependenteDto> listar() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
} 