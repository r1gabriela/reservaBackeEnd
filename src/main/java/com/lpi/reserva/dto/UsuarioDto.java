package com.lpi.reserva.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class UsuarioDto {
	
	@NotNull(message="{id.not.null}")
	private Integer idUsuario;
	
	@NotBlank
	private PessoaDto pessoa;
	
	@NotBlank(message="{login.not.blank}")
	private String login;
	
	@NotBlank(message="{senha.not.blank}")
	private String senha;

	@NotBlank(message="{role.not.blank}")
	private RoleDto role;
	
	private Boolean ativo;
	
}