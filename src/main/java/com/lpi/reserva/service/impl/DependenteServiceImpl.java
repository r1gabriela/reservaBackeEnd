package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Exception.ExceptionResponse;
import com.lpi.reserva.Repository.ClienteRepository;
import com.lpi.reserva.Repository.DependenteRepository;
import com.lpi.reserva.Repository.PessoaRepository;
import com.lpi.reserva.dto.ClienteDto;
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
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private SecurityServiceImpl securityServiceImpl;
	
	public DependenteServiceImpl(DependenteRepository dependenteRepository) {
		this.dependenteRepository = dependenteRepository;
	}
		
	@Override
	public DependenteDto salvar(DependenteDto dependenteDto) throws Exception, ExceptionResponse {
		try {
			Pessoa pessoa = pessoaService.pesquisarPorCpf(dependenteDto.getCpf());
			Dependente dependente = new Dependente();
			
			ClienteDto clienteDto = new ClienteDto();
			clienteDto.setIdPessoa(pessoaRepository.pesquisarIdPessoaPorLogin(securityServiceImpl.findLoggedInUsername()));
			dependenteDto.setCliente(clienteDto);
			
			if (pessoa == null || pessoa.getIdPessoa() == dependenteDto.getIdPessoa()) {
				dependente = dependenteRepository.save(new ModelMapper().map(dependenteDto, Dependente.class));
			} else {
				throw new ExceptionResponse("Cpf já cadastrado.");
			}
			
			return new ModelMapper().map(dependente, DependenteDto.class);
		} catch(ExceptionResponse ex) {
			throw new ExceptionResponse(ex.getMessage());
		} catch(Exception e) {
			throw new Exception(e.getMessage());
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
	public ArrayList<PessoaDto> listarPessoasDeCliente(){
		return listarPessoas(clienteRepository.pesquisarClientePorId(pessoaRepository.pesquisarIdPessoaPorLogin(securityServiceImpl.findLoggedInUsername())));
	}

	@Override
	public ArrayList<PessoaDto> listarPessoas(Dependente dependente){
		ArrayList<PessoaDto> listDto = new ArrayList<>();
		
		listDto = new ModelMapper().map(dependente, new TypeToken<ArrayList<PessoaDto>>() {}.getType());
		return listDto;
	}
	
	@Override
	public ArrayList<DependenteDto> listarDependentes(){
		return new ModelMapper().map(dependenteRepository.pesquisarDependentePorCliente(pessoaRepository.pesquisarIdPessoaPorLogin(securityServiceImpl.findLoggedInUsername())), new TypeToken<ArrayList<DependenteDto>>() {}.getType());
	}
} 