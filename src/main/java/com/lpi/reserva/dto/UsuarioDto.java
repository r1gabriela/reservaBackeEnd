package com.lpi.reserva.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class UsuarioDto extends ClienteDto{
	
	private Integer idUsuario;
	
	private PessoaDto pessoa;
	
	private String login;
	
	private String senha;
	
	private RoleDto role;
	
	private Boolean ativo;
	
}