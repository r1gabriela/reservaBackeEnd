package com.lpi.reserva.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class TipoFuncionarioDto extends PessoaDto{
	
	private Integer idTipoFuncionario;
	
	private String descricao;
	
	private Boolean ativo;

}
