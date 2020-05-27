package com.lpi.reserva.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class RoleDto {

	@NotNull(message="{id.not.null}")
	private Integer idRole;
	
	@NotBlank(message="{nome.not.blank}")
	private String nome;
	
	@JsonBackReference(value = "privilegios")
	private List<PrivilegioDto> privilegios;
	
	@JsonBackReference(value = "usuarios")
	private List<UsuarioDto> usuarios;
	
}
