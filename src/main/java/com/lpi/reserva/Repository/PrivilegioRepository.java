package com.lpi.reserva.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.lpi.reserva.entity.Privilegio;

@Repository
public interface PrivilegioRepository extends CrudRepository<Privilegio, Integer> {
	
	@Query(value = "SELECT p FROM Privilegio p WHERE LOWER(p.nome) = :nome OR p.url = :url")
	public Privilegio pesquisarDuplicado(@Param("nome") String nome, @Param("url") String url);

}
