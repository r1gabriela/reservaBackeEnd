package com.lpi.reserva.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class UsuarioDto extends ClienteDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3088003734046720510L;

	private Integer idUsuario;
	
	private PessoaDto pessoa;
	
	private String login;
	
	private String senha;

	private RoleDto role;
	
	private Boolean ativo;
	
}