package com.lpi.reserva.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class RoleDto {

	private Integer idRole;
	
	private String nome;
	
	private List<PrivilegioDto> privilegios;
	
	private List<UsuarioDto> usuarios;
	
}
