package com.lpi.reserva.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;



import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class ClienteDto extends PessoaDto {
	
	@NotBlank
	private String telefone;

	@NotBlank
	@Email
	private String email;

	@JsonBackReference(value = "reservas")
	private List<ReservaDto> reservas;	
	
	@JsonBackReference(value = "dependentes")
	private List<DependenteDto> dependente;
	
	@JsonBackReference(value = "datasComemorativas")
	private List<DataComemorativaDto> datasComemorativas;
	
}
