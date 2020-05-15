package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.FuncionarioRepository;
import com.lpi.reserva.dto.FuncionarioDto;
import com.lpi.reserva.entity.Funcionario;
import com.lpi.reserva.entity.Pessoa;
import com.lpi.reserva.entity.TipoFuncionario;
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
	public FuncionarioDto salvar(FuncionarioDto funcionarioDto) {
		try {
			Pessoa pessoa = new Pessoa();
			
			pessoa = pessoaService.pesquisarPorCpf(funcionarioDto.getCpf());
			
			if (pessoa == null || pessoa.getIdPessoa() == funcionarioDto.getIdPessoa()) {
				funcionarioRepository.save(preencherFuncionario(funcionarioDto));
			} else {
				throw new IllegalArgumentException("Cpf já cadastrado.");
			}
			
			return funcionarioDto;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}

	@Override
	public Funcionario preencherFuncionario(FuncionarioDto funcionarioDto) {
		Funcionario funcionario = new Funcionario();
		funcionario.setIdPessoa(funcionarioDto.getIdPessoa());
		funcionario.setNome(funcionarioDto.getNome());
		funcionario.setCpf(funcionarioDto.getCpf());
		TipoFuncionario tipo = new TipoFuncionario();
		tipo.setIdTipoFuncionario(funcionarioDto.getIdTipoFuncionario());
		funcionario.setTipoFuncionario(tipo);
		return funcionario;
	}

	@Override
	public FuncionarioDto preencherFuncionarioDto(Funcionario funcionario) {
		FuncionarioDto funcionarioDto = new FuncionarioDto();
		funcionarioDto.setIdPessoa(funcionario.getIdPessoa());
		funcionarioDto.setNome(funcionario.getNome());
		funcionarioDto.setCpf(funcionario.getCpf());
		funcionarioDto.setIdTipoFuncionario(funcionario.getTipoFuncionario().getIdTipoFuncionario());
		return funcionarioDto;
	}
	
	@Override
	public FuncionarioDto pesquisarPorId(int idPessoa) {
		return preencherFuncionarioDto(funcionarioRepository.findById(idPessoa).get());
	}
	
	@Override
	public ArrayList<FuncionarioDto> listarTodos() {
		return listaDto(funcionarioRepository.findAll());
	}
	
	@Override
	public ArrayList<FuncionarioDto> listaDto(Iterable<Funcionario> funcionarios){
		ArrayList<FuncionarioDto> listaDto = new ArrayList<>();
        for(Funcionario funcionario: funcionarios) 
            listaDto.add(preencherFuncionarioDto(funcionario));
    
        return listaDto;		
	}

}