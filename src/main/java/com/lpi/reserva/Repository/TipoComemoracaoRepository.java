package com.lpi.reserva.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.lpi.reserva.entity.TipoComemoracao;

@Repository
public interface TipoComemoracaoRepository extends CrudRepository<TipoComemoracao, Integer> {

	@Query(value = "SELECT t FROM TipoComemoracao t WHERE t.ativo = :ativo")
	public Iterable<TipoComemoracao>listarPorAtivo(@Param("ativo") boolean ativo);
	
}
