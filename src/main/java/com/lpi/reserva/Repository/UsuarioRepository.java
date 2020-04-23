package com.lpi.reserva.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.lpi.reserva.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	@Query(value = "SELECT u FROM Usuario u WHERE u.login = :login")
	public Usuario pesquisarUsuarioPorLogin(@Param("login") String login);
	
}
