package com.lpi.reserva.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.lpi.reserva.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	
	@Query(value = "SELECT c FROM Cliente c WHERE c.cpf = :cpf")
	public Cliente pesquisarClientePorCpf(@Param("cpf") String cpf);
	
}