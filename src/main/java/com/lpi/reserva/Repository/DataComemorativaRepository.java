package com.lpi.reserva.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lpi.reserva.entity.DataComemorativa;

@Repository
public interface DataComemorativaRepository extends CrudRepository<DataComemorativa, Integer> {

	@Query(value = "SELECT d FROM DataComemorativa d WHERE d.cliente.idPessoa = :idCliente AND d.pessoa.idPessoa = :idPessoa AND d.tipoComemoracao.idTipoComemoracao = :idTipoComemoracao")
	public DataComemorativa pesquisarDataComemorativaRepetidada(@Param("idCliente") Integer idCliente, @Param("idPessoa") Integer idPessoa, @Param("idTipoComemoracao") Integer idTipoComemoracao);
	
	@Query(value = "SELECT d FROM DataComemorativa d WHERE d.tipoComemoracao.idTipoComemoracao = :idTipoComemoracao")
	public Iterable<DataComemorativa> pesquisarPorIdTipoComemoracao(@Param("idTipoComemoracao") Integer idTipoComemoracao);
	
	@Query(value = "SELECT d FROM DataComemorativa d WHERE d.cliente.idPessoa = :idCliente")
	public Iterable<DataComemorativa> findAllCliente(@Param("idCliente") Integer idCliente);
	
}