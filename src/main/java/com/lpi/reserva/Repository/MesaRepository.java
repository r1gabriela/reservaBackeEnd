package com.lpi.reserva.Repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lpi.reserva.entity.Mesa;

@Repository
public interface MesaRepository extends CrudRepository<Mesa, Integer> {
	
	@Query(value = "SELECT m FROM Mesa m  WHERE m.idMesa NOT IN "
			+ "(SELECT m.idMesa FROM Reserva r JOIN r.mesa m "
			+ "WHERE r.horaEntrada >= :horaEntrada AND r.horaEntrada < :horaSaida "
			+ "OR r.horaSaida > :horaEntrada AND r.horaSaida < :horaSaida AND r.dataReserva = :dataReserva AND r.ativo = true)"
			+ " AND m.capacidade = :capacidade AND m.ativo = true")
	public List<Mesa> verDisponibilidadeMesa(@Param("horaEntrada") Time horaEntrada, @Param("horaSaida") Time horaSaida, @Param("capacidade") Integer capacidade, @Param("dataReserva") Date dataReserva);

}