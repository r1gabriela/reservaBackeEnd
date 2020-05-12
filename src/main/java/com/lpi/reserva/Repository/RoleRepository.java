package com.lpi.reserva.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.lpi.reserva.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	@Query(value = "SELECT r FROM Role r WHERE LOWER(r.nome) = :nome")
	public Role pesquisarPorNome(@Param("nome") String nome);
	
}
