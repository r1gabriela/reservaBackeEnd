package com.lpi.reserva.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class ClienteDto extends PessoaDto {

	private String telefone;

	private String email;

	private List<ReservaDto> reservas;

	private List<DependenteDto> dependente;

	private List<DataComemorativaDto> datasComemorativas;
	
}
