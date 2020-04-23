package com.lpi.reserva.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lpi.reserva.entity.TipoComemoracao;

@Repository
public interface TipoComemoracaoRepository extends CrudRepository<TipoComemoracao, Integer> {

	@Query(value = "SELECT t FROM TipoComemoracao t WHERE t.ativo = true")
	public Iterable<TipoComemoracao>listarPorAtivo();

}