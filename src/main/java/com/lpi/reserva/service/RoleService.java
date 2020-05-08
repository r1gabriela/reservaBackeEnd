package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.RoleDto;
import com.lpi.reserva.entity.Role;

public interface RoleService {

	public ArrayList<RoleDto> salvar(ArrayList<RoleDto> rolesDto);
	
	public ArrayList<Role> preencherListaRole(ArrayList<RoleDto> rolesDto);

	public Role preencherRole(RoleDto roleDto);
	
}
