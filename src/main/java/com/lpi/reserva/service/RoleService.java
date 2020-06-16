package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.RoleDto;
import com.lpi.reserva.entity.Role;

public interface RoleService {

	public ArrayList<RoleDto> salvar(ArrayList<RoleDto> rolesDto) throws Exception;
	
	public ArrayList<Role> preencherListaRole(ArrayList<RoleDto> rolesDto) throws Exception;

	public Role preencherRole(RoleDto roleDto) throws Exception;

	public ArrayList<RoleDto> listar();
	
	public RoleDto roleUsuarioLogado();
	
}