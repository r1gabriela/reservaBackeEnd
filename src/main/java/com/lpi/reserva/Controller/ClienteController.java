package com.lpi.reserva.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ClienteDto salvar(ClienteDto clienteDto) {
		return clienteServiceImpl.salvar(clienteDto);
	}
	
	@RequestMapping(value = "/pesquisarPorId", method = RequestMethod.GET)
    public ClienteDto pesquisarPorId(@RequestParam(value = "idPessoa") int idPessoa) {
    	return clienteServiceImpl.pesquisarPorId(idPessoa);	
    }
	
}