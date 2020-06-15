package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Exception.ExceptionResponse;
import com.lpi.reserva.Repository.PrivilegioRepository;
import com.lpi.reserva.Repository.RoleRepository;
import com.lpi.reserva.Repository.UsuarioRepository;
import com.lpi.reserva.dto.PrivilegioDto;
import com.lpi.reserva.dto.RoleDto;
import com.lpi.reserva.entity.Privilegio;
import com.lpi.reserva.entity.Role;
import com.lpi.reserva.service.RoleService;
import com.lpi.reserva.service.SecurityService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private SecurityServiceImpl securityServiceImpl;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PrivilegioRepository privilegioRepository;
	
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@Override
	public ArrayList<RoleDto> salvar(ArrayList<RoleDto> rolesDto) throws Exception {
		Iterable<Role> list = roleRepository.saveAll(preencherListaRole(rolesDto)); 
		return new ModelMapper().map(list, new TypeToken<ArrayList<RoleDto>>() {}.getType());	
	}

	@Override
	public Role preencherRole(RoleDto roleDto) throws Exception, ExceptionResponse {
		Role role;
		try	{
			role = roleRepository.pesquisarPorNome(roleDto.getNome().toLowerCase());
			
			if (role == null || role.getIdRole() == roleDto.getIdRole()) {
				if (roleDto.getIdRole() != null)
					role = roleRepository.findById(roleDto.getIdRole()).get();
				
				if (role == null)
					role = new Role();
				
				role = new ModelMapper().map(roleDto, Role.class);
				
				
				ArrayList<Privilegio> privilegios = new ArrayList<>();
				if (role.getPrivilegios() != null)
					privilegios.addAll(role.getPrivilegios());
				
				for (PrivilegioDto privilegioDto: roleDto.getPrivilegios()) {
					Privilegio privilegio = privilegioRepository.findById(privilegioDto.getId()).get();
					privilegios.add(privilegio);
				}
				
				role.setPrivilegios(privilegios);
			} else {
				throw new ExceptionResponse("Role " + roleDto.getNome() + " ja cadastrada");
			} 
			
			return role;
		} catch(ExceptionResponse ex) {
			throw new ExceptionResponse(ex.getMessage());
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public ArrayList<Role> preencherListaRole(ArrayList<RoleDto> rolesDto) throws Exception {
		 ArrayList<Role> roles = new ArrayList<>();

		 for (RoleDto roleDto: rolesDto) {
			 Role role = preencherRole(roleDto);
			 if (role != null )
				 roles.add(role);
		 }
		 
		return roles;
	}

	@Override
	public ArrayList<RoleDto> listar() {
		return new ModelMapper().map(roleRepository.listarDiferenteNome(("User").toLowerCase()), new TypeToken<ArrayList<RoleDto>>() {}.getType());
	}

	@Override
	public String roleUsuarioLogado() {
		String login = securityServiceImpl.findLoggedInUsername();
		
		if(login == null) 
			return null;
		
		return usuarioRepository.roleUsuarioLogado(login);
	}

}
