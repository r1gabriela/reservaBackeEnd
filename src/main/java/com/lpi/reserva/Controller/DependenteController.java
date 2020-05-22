package com.lpi.reserva.Controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpi.reserva.dto.DependenteDto;
import com.lpi.reserva.dto.PessoaDto;
import com.lpi.reserva.service.impl.DependenteServiceImpl;

@RestController
@RequestMapping(path="/dependente")
public class DependenteController {

	@Autowired
	private DependenteServiceImpl dependenteService;
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public DependenteDto salvar(@RequestBody @Valid DependenteDto dependenteDto) {
		return dependenteService.salvar(dependenteDto);
	}
	
	@RequestMapping(value = "/excluir", method = RequestMethod.GET)
	public boolean excluir(@RequestParam(value = "idPessoa") Integer idPessoa) {
		return dependenteService.excluir(idPessoa);
	}
	
	@RequestMapping(value = "/listarPessoasDeCliente", method = RequestMethod.GET)
	public ArrayList<PessoaDto> listarPessoas(@RequestParam(value = "idCliente") Integer idCliente){
		return dependenteService.listarPessoasDeCliente(idCliente);
	}
	
}