package com.lpi.reserva.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public FuncionarioDto salvar(FuncionarioDto funcionarioDto) {
		return funcionarioServiceImpl.salvar(funcionarioDto);
	}
	
}