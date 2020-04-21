package com.lpi.reserva.Repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.lpi.reserva.dto.TipoComemoracaoDto;
import com.lpi.reserva.entity.TipoComemoracao;

@Repository
public interface TipoComemoracaoRepository extends CrudRepository<TipoComemoracao, Integer> {

	
}
