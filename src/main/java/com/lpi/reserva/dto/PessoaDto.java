package com.lpi.reserva.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class PessoaDto {
	
	@NotNull(message = "{id.not.null}")
	private Integer idPessoa;

	@NotBlank(message = "{nome.not.blank}")
	private String nome;

	@NotBlank
	@Pattern(regexp =  "d{11}")
	private String cpf;
	
}
