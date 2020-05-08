package com.lpi.reserva.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.lpi.reserva.entity.Privilegio;

@Repository
public interface PrivilegioRepository extends CrudRepository<Privilegio, Integer> {

}
