package com.lpi.reserva.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class ClienteDto extends PessoaDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5693472436025588816L;

	private String telefone;

	private String email;

	@JsonBackReference(value = "reservas")
	private List<ReservaDto> reservas;	
	
	@JsonBackReference(value = "dependentes")
	private List<DependenteDto> dependente;
	
	@JsonBackReference(value = "datasComemorativas")
	private List<DataComemorativaDto> datasComemorativas;
	
}
