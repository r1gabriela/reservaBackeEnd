package com.lpi.reserva.Controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpi.reserva.dto.FuncionarioDto;
import com.lpi.reserva.service.impl.FuncionarioServiceImpl;

@RestController
@RequestMapping(path="/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioServiceImpl funcionarioServiceImpl;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public FuncionarioDto salvar(@RequestBody @Valid FuncionarioDto funcionarioDto) throws Exception {
		return funcionarioServiceImpl.salvar(funcionarioDto);
	}

	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public ArrayList<FuncionarioDto> listarTodos(){
		return funcionarioServiceImpl.listarTodos();
	}
	
}