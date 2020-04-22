package com.lpi.reserva.dto;

import java.util.List;

import com.lpi.reserva.entity.DataComemorativa;
import com.lpi.reserva.entity.Dependente;
import com.lpi.reserva.entity.Reserva;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class ClienteDto extends PessoaDto {

	private String telefone;

	private String email;

	private List<Reserva> reservas;

	private List<Dependente> dependente;

	private List<DataComemorativa> datasComemorativas;
	
}
