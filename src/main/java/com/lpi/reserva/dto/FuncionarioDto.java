package com.lpi.reserva.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class FuncionarioDto extends PessoaDto implements Serializable{ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1385211923067074028L;
	
	
	private TipoFuncionarioDto tipoFuncionario;
	
}