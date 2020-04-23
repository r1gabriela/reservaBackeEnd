package com.lpi.reserva.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lpi.reserva.entity.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {

	@Query(value = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf")
	public Pessoa pesquisarPorCpf(@Param("cpf") String cpf);
	
}