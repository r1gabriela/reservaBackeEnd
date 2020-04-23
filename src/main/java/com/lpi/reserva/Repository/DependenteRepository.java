package com.lpi.reserva.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lpi.reserva.entity.Pessoa;

@Repository
public interface DependenteRepository extends CrudRepository<Pessoa, Integer> {

}