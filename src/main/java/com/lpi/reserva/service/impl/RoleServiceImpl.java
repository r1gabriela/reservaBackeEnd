package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.PrivilegioRepository;
import com.lpi.reserva.Repository.RoleRepository;
import com.lpi.reserva.dto.PrivilegioDto;
import com.lpi.reserva.dto.RoleDto;
import com.lpi.reserva.entity.Privilegio;
import com.lpi.reserva.entity.Role;
import com.lpi.reserva.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PrivilegioRepository privilegioRepository;
	
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@Override
	public ArrayList<RoleDto> salvar(ArrayList<RoleDto> rolesDto) {
		roleRepository.saveAll(preencherListaRole(rolesDto)); 
		return rolesDto;	
	}

	@Override
	public Role preencherRole(RoleDto roleDto) {
		Role role;
		try	{
			role = roleRepository.pesquisarPorNome(roleDto.getNome().toLowerCase());
			
			if (role == null || role.getIdRole() == roleDto.getIdRole()) {
				if (roleDto.getIdRole() != 0)
					role = roleRepository.findById(roleDto.getIdRole()).get();
				
				if (role == null)
					role = new Role();
				
				role.setIdRole(roleDto.getIdRole());
				role.setNome(roleDto.getNome());
				
				ArrayList<Privilegio> privilegios = new ArrayList<>();
				if (role.getPrivilegios() != null)
					privilegios.addAll(role.getPrivilegios());
				
				for (PrivilegioDto privilegioDto: roleDto.getPrivilegios()) {
					Privilegio privilegio = privilegioRepository.findById(privilegioDto.getId()).get();
					privilegios.add(privilegio);
				}
				
				role.setPrivilegios(privilegios);
			} else {
				throw new Exception("Role " + roleDto.getNome() + " ja cadastrada");
			} 
			
			return role;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Role> preencherListaRole(ArrayList<RoleDto> rolesDto) {
		 ArrayList<Role> roles = new ArrayList<>();

		 for (RoleDto roleDto: rolesDto) {
			 Role role = preencherRole(roleDto);
			 if (role != null )
				 roles.add(role);
		 }
		 
		return roles;
	}

}
