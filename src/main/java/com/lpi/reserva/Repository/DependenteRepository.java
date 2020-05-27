package com.lpi.reserva.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lpi.reserva.entity.Dependente;

@Repository
public interface DependenteRepository extends CrudRepository<Dependente, Integer> {
	
	@Query(value = "SELECT d FROM Dependente d JOIN d.cliente c WHERE c.idPessoa = :idPessoa")
	public List<Dependente> pesquisarDependentePorCliente(@Param("idPessoa") Integer idPessoa);

}
