package com.lpi.reserva.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpi.reserva.dto.RoleDto;
import com.lpi.reserva.service.impl.RoleServiceImpl;

@RestController
@RequestMapping(path="/role")
public class RoleController {

	@Autowired
	private RoleServiceImpl roleService;
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ArrayList<RoleDto> salvar(@RequestBody ArrayList<RoleDto> arrayList){
		return roleService.salvar(arrayList);
	}	
	
}
