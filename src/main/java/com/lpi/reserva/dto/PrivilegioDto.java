package com.lpi.reserva.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class PrivilegioDto {
	
	private Integer id;
	
	private String nome;
	
	private String url;
	
	private List<RoleDto> roles;
	
}
