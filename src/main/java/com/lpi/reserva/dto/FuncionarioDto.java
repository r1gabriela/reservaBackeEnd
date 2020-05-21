package com.lpi.reserva.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class FuncionarioDto extends PessoaDto {
	
	@NotBlank
	private TipoFuncionarioDto tipoFuncionario;
	
}