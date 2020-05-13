package com.lpi.reserva.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lpi.reserva.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	
	@Query(value = "SELECT c FROM Cliente c WHERE c.cpf = :cpf")
	public Cliente pesquisarClientePorCpf(@Param("cpf") String cpf);
	
	@Query(value = "SELECT c FROM Cliente c JOIN c.dependente d WHERE c.idPessoa = :idPessoa")
	public Cliente pesquisarClientePorId(@Param("idPessoa") Integer idPessoa);
	
}