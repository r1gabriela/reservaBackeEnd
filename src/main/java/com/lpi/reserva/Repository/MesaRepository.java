package com.lpi.reserva.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lpi.reserva.entity.Mesa;

@Repository
public interface MesaRepository extends CrudRepository<Mesa, Integer> {
	
}