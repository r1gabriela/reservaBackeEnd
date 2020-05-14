package com.lpi.reserva.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lpi.reserva.entity.TipoComemoracao;

@Repository
public interface TipoComemoracaoRepository extends CrudRepository<TipoComemoracao, Integer> {

	@Query(value = "SELECT t FROM TipoComemoracao t WHERE t.ativo = true")
	public Iterable<TipoComemoracao>listarPorAtivo();
	
	@Query(value = "SELECT t FROM TipoComemoracao t Where LOWER(t.descricao) = :descricao")
	public TipoComemoracao pesquisarDescricao(@Param("descricao") String descricao);

}