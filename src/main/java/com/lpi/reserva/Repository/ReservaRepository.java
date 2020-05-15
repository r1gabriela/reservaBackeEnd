package com.lpi.reserva.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lpi.reserva.entity.Reserva;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Integer> {

}
