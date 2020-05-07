package com.lpi.reserva.service;

import com.lpi.reserva.dto.UsuarioDto;
import com.lpi.reserva.entity.Usuario;


public interface UsuarioService{
	
	public UsuarioDto salvar(UsuarioDto usuarioDto);

	public  Usuario preencherUsuario(UsuarioDto usuarioDto);

	public boolean excluir(Integer idUsuario);

	public UsuarioDto pesquisarPorId(int idUsuario);

	public UsuarioDto preencherUsuarioDto(Usuario usuario);

	
}