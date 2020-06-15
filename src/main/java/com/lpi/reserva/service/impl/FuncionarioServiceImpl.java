package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Exception.ExceptionResponse;
import com.lpi.reserva.Repository.FuncionarioRepository;
import com.lpi.reserva.dto.FuncionarioDto;
import com.lpi.reserva.entity.Funcionario;
import com.lpi.reserva.entity.Pessoa;
import com.lpi.reserva.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private PessoaServiceImpl pessoaService;
	
	public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	@Override
	public FuncionarioDto salvar(FuncionarioDto funcionarioDto) throws Exception, ExceptionResponse {
		try {
			Pessoa pessoa = pessoaService.pesquisarPorCpf(funcionarioDto.getCpf());
			Funcionario funcionario = new Funcionario();
			
			if (pessoa == null || pessoa.getIdPessoa() == funcionarioDto.getIdPessoa()) {
				funcionario = funcionarioRepository.save(new ModelMapper().map(funcionarioDto, Funcionario.class));
			} else {
				throw new ExceptionResponse("Cpf já cadastrado.");
			}
			
			return new ModelMapper().map(funcionario, FuncionarioDto.class);
		} catch(ExceptionResponse ex) {
			throw new ExceptionResponse(ex.getMessage());
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public ArrayList<FuncionarioDto> listarTodos() {
		ArrayList<FuncionarioDto> funcionarios = new ArrayList<>();
		Iterable<Funcionario> iterable = funcionarioRepository.findAll();
		
		if (iterable != null)
			funcionarios = new ModelMapper().map(iterable, new TypeToken<ArrayList<FuncionarioDto>>() {}.getType());
		
		return funcionarios;
	}
	
}