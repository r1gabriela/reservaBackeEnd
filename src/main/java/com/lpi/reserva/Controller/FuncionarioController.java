package com.lpi.reserva.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpi.reserva.dto.FuncionarioDto;
import com.lpi.reserva.service.impl.FuncionarioServiceImpl;

@RestController
@RequestMapping(path="/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioServiceImpl funcionarioServiceImpl;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public FuncionarioDto salvar(FuncionarioDto funcionarioDto) {
		return funcionarioServiceImpl.salvar(funcionarioDto);
	}
	
	@RequestMapping(value = "/pesquisarPorId", method = RequestMethod.GET)
    public FuncionarioDto pesquisarPorId(@RequestParam(value = "idPessoa") int idPessoa) {
    	return funcionarioServiceImpl.pesquisarPorId(idPessoa);	
    }
	
	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public ArrayList<FuncionarioDto> listarTodos(){
		return funcionarioServiceImpl.listarTodos();
	}
	
}