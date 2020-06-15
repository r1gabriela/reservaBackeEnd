package com.lpi.reserva.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class TipoComemoracaoDto {
	
	@NotNull(message="{id.not.null}")
	private Integer idTipoComemoracao;

	@NotBlank(message="{descricao.not.blank}")
	private String descricao;
	
	private Boolean ativo;
	
}