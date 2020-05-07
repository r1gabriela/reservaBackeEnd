package com.lpi.reserva.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class UsuarioDto {
	
	private Integer idUsuario;
	
	private Integer idPessoa;
	
	private String login;
	
	private String senha;
	
	private Boolean ativo;

}