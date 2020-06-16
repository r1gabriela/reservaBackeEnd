package com.lpi.reserva.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.lpi.reserva.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	@Query(value = "SELECT r FROM Role r WHERE LOWER(r.nome) = :nome")
	public Role pesquisarPorNome(@Param("nome") String nome);
	
	@Query(value = "SELECT r FROM Role r WHERE LOWER(r.nome) != :nome")
	public List<Role> listarDiferenteNome(@Param("nome") String nome);
	
	@Query(value = "SELECT r FROM Usuario u JOIN u.role r WHERE u.login = :login")
	public Role roleUsuarioLogado(@Param("login") String login);
	
}