package com.lpi.reserva.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.lpi.reserva.Repository.UsuarioRepository;
import com.lpi.reserva.entity.Usuario;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.pesquisarUsuarioPorLogin(login);
		if(usuario == null) {
			throw new UsernameNotFoundException("Login não encontrado");
		}
		return usuario;
	}

}
