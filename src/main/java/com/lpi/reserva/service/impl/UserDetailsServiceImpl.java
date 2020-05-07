package com.lpi.reserva.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.UsuarioRepository;
import com.lpi.reserva.entity.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.pesquisarUsuarioPorLogin(login);
		if(usuario == null) {
			throw new UsernameNotFoundException("Login não encontrado");
		}
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		return new org.springframework.security.core.userdetails.User("", "", grantedAuthorities);
	}

}
