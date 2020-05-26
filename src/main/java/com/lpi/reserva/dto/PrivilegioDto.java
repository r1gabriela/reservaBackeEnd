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
public class PrivilegioDto {
	
	@NotNull(message="{id.not.null}")
	private Integer id;
	
	@NotBlank(message="{nome.not.blank}")
	private String nome;
	
	@NotBlank(message="{url.not.blank}")
	private String url;
	
	@NotNull
	@JsonBackReference(value = "roles")
	private List<RoleDto> roles;
	
}
