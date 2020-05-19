package com.lpi.reserva.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lpi.reserva.dto.UsuarioDto;
import com.lpi.reserva.service.impl.SecurityServiceImpl;
import com.lpi.reserva.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping(path="/usuario")
public class UsuarioController {
	
	@Autowired
	private SecurityServiceImpl securityService;
	@Autowired
	private UsuarioServiceImpl usuarioService;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public UsuarioDto salvar(@RequestBody UsuarioDto usuarioDto) {
		return usuarioService.salvar(usuarioDto);
	}	
	
	@RequestMapping(value = "/excluir", method = RequestMethod.GET)
	public boolean excluir(@RequestParam(value = "idUsuario") int idUsuario) {
		return usuarioService.excluir(idUsuario);
	}
	
	@RequestMapping(value = "/pesquisarPorId", method = RequestMethod.GET)
    public UsuarioDto pesquisarPorId(@RequestParam(value = "idUsuario") int idUsuario) {
    	return usuarioService.pesquisarPorId(idUsuario);	
    }
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public UsuarioDto cadastrar(@RequestBody UsuarioDto usuarioDto) {
		return usuarioService.cadastrar(usuarioDto);
	}
	
	@RequestMapping(value = "/logar", method = RequestMethod.POST)
	public UsuarioDto logar(@RequestBody UsuarioDto usuarioDto) {
		securityService.autoLogin(usuarioDto.getLogin(), usuarioDto.getSenha());
		return usuarioDto;
	}
	
	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public ArrayList<UsuarioDto> listarTodos(){
		return usuarioService.listarTodos();
	}

}