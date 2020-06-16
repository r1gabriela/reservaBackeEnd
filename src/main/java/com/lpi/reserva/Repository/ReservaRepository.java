package com.lpi.reserva.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lpi.reserva.entity.Reserva;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Integer> {

	@Query(value = "SELECT r FROM Reserva r JOIN r.cliente c WHERE c.idPessoa = :idPessoa")
	public List<Reserva> pesquisarReservaPorCliente(@Param("idPessoa") Integer idPessoa);
	
}