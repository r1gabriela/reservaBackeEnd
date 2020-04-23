
package com.lpi.reserva.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.UsuarioRepository;
import com.lpi.reserva.dto.UsuarioDto;
import com.lpi.reserva.entity.Pessoa;
import com.lpi.reserva.entity.Usuario;
import com.lpi.reserva.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
		
	@Autowired
	private UsuarioRepository usuarioRepository;
		
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public UsuarioDto salvar(UsuarioDto usuarioDto) {
		try	{
			Usuario usuario = new Usuario();
			
			if (usuarioDto.getIdUsuario() == 0)
				usuario = usuarioRepository.pesquisarUsuarioPorLogin(usuarioDto.getLogin());
			
			if (usuario == null || usuario.getIdUsuario() == null)
				usuarioRepository.save(preencherUsuario(usuarioDto));
			else 
				throw new IllegalArgumentException("Login já Cadastrado.");
			
			return usuarioDto;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}
	
	@Override
	public Usuario preencherUsuario(UsuarioDto usuarioDto) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(usuarioDto.getIdUsuario());
		Pessoa pessoa = new Pessoa();
		pessoa.setIdPessoa(usuarioDto.getIdPessoa());
		usuario.setPessoa(pessoa);
		usuario.setAtivo(usuarioDto.getAtivo());
		usuario.setLogin(usuarioDto.getLogin());
		usuario.setSenha(usuarioDto.getSenha());
		return usuario;
	} 

}