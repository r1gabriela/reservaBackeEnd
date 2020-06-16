package com.lpi.reserva.Controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpi.reserva.dto.RoleDto;
import com.lpi.reserva.entity.Role;
import com.lpi.reserva.service.impl.RoleServiceImpl;

@RestController
@RequestMapping(path="/role")
public class RoleController {

	@Autowired
	private RoleServiceImpl roleService;
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ArrayList<RoleDto> salvar(@RequestBody @Valid ArrayList<RoleDto> arrayList) throws Exception{
		return roleService.salvar(arrayList);
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ArrayList<RoleDto> listarRole(){
		return roleService.listar();
	}
	
	@RequestMapping(value="/roleUsuarioLogado", method = RequestMethod.GET)
	public RoleDto roleUsuarioLogado() {
		return roleService.roleUsuarioLogado();
	}
	
}