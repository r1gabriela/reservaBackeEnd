package com.lpi.reserva.Controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpi.reserva.dto.ClienteDto;
import com.lpi.reserva.service.impl.ClienteServiceImpl;

@RestController
@RequestMapping(path="/cliente")
public class ClienteController {

	@Autowired
	private ClienteServiceImpl clienteServiceImpl;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ClienteDto salvar(@RequestBody @Valid ClienteDto clienteDto) throws Exception {
		return clienteServiceImpl.salvar(clienteDto);
	}
	
	@RequestMapping(value = "/pesquisarPorId", method = RequestMethod.GET)
    public ClienteDto pesquisarPorId(@RequestParam(value = "idPessoa") int idPessoa) {
    	return clienteServiceImpl.pesquisarPorId(idPessoa);	
    }
	
	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public ArrayList<ClienteDto> listarTodos(){
		return clienteServiceImpl.listarTodos();
	}
	
}