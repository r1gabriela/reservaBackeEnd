package com.lpi.reserva.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpi.reserva.dto.UsuarioDto;
import com.lpi.reserva.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping(path="/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImpl usuarioService;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public UsuarioDto salvar(UsuarioDto usuarioDto) {
		return usuarioService.salvar(usuarioDto);
	}	

}