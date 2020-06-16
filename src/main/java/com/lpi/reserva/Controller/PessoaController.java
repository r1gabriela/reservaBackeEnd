package com.lpi.reserva.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lpi.reserva.dto.PessoaDto;
import com.lpi.reserva.service.impl.PessoaServiceImpl;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
	
	@Autowired
	PessoaServiceImpl  pessoaService;
	
	@RequestMapping(value = "/pesquisarPorNome", method = RequestMethod.GET)
	public ArrayList<PessoaDto> pesquisarPorNome(@RequestParam(value= "nome") String nome) {
		return pessoaService.pesquisarPorNome(nome);
	}
	
	@RequestMapping(value ="/listarNaoCadastradoPorCpf", method = RequestMethod.GET)
	public ArrayList<PessoaDto> pesquisarUsuarioNaoCadastradoPorCpf(@RequestParam(value= "cpf")String cpf){
		return pessoaService.pesquisarUsuarioNaoCadastradoPorCpf(cpf);
	}
	
}