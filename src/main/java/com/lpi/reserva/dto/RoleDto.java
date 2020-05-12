package com.lpi.reserva.dto;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class RoleDto {

	private Integer idRole;
	
	private String nome;
	
	private ArrayList<PrivilegioDto> privilegios;
	
}
