package com.lpi.reserva.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lpi.reserva.Repository.UsuarioRepository;
import com.lpi.reserva.entity.Privilegio;
import com.lpi.reserva.entity.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.pesquisarUsuarioPorLogin(login);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Login não encontrado");
		}
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		for (Privilegio privilegio: usuario.getRole().getPrivilegios())
			grantedAuthorities.add(new SimpleGrantedAuthority(privilegio.getNome()));
		
		return new org.springframework.security.core.userdetails.User(usuario.getLogin(), usuario.getSenha(), grantedAuthorities);
	}

}
