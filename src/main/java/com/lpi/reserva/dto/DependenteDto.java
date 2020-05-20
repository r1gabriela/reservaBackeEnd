package com.lpi.reserva.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class DependenteDto extends PessoaDto {
	
	private ClienteDto cliente;
	
	private Boolean ativo;
	
}