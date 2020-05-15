package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.UsuarioDto;
import com.lpi.reserva.entity.Usuario;


public interface UsuarioService{
	
	public UsuarioDto salvar(UsuarioDto usuarioDto);

	public  Usuario preencherUsuario(UsuarioDto usuarioDto);

	public boolean excluir(Integer idUsuario);

	public UsuarioDto pesquisarPorId(int idUsuario);

	public UsuarioDto preencherUsuarioDto(Usuario usuario);

	public UsuarioDto cadastrar(UsuarioDto usuarioDto);
	
	public ArrayList<UsuarioDto> listarTodos();

	public ArrayList<UsuarioDto> listaDto(Iterable<Usuario> usuarios);	
	
}