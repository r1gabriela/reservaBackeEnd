package com.lpi.reserva.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class RoleDto {

	private Integer idRole;
	
	private String nome;
	
	@JsonBackReference(value = "privilegios")
	private List<PrivilegioDto> privilegios;
	
	@JsonBackReference(value = "usuarios")
	private List<UsuarioDto> usuarios;
	
}
