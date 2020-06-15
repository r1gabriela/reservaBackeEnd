package com.lpi.reserva.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

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

	@CPF
	private String cpf;
	
}