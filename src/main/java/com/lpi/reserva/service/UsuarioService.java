package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.UsuarioDto;


public interface UsuarioService{
	
	public UsuarioDto salvar(UsuarioDto usuarioDto) throws Exception;

	public boolean excluir(Integer idUsuario);

	public UsuarioDto pesquisarPorId(int idUsuario);

	public UsuarioDto cadastrar(UsuarioDto usuarioDto);
	
	public ArrayList<UsuarioDto> listarTodos();

		
	
}