package com.lpi.reserva.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lpi.reserva.entity.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {

	@Query(value = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf")
	public Pessoa pesquisarPorCpf(@Param("cpf") String cpf);
	
	@Query(value = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf")
	public Pessoa listarPorCpf(@Param("cpf") String cpf);
	
	@Query(value = "SELECT p FROM Pessoa p WHERE LOWER (p.nome) LIKE %:nome%")
	public List<Pessoa> pesquisarPorNome(@Param("nome") String nome);
	
	@Query(value = "SELECT p.idPessoa FROM Usuario u JOIN u.pessoa p WHERE u.login = :login")
	public Integer pesquisarIdPessoaPorLogin(@Param("login") String login);
	
	@Query(value = "SELECT p FROM Pessoa p WHERE p.cpf LIKE :cpf%  " + 
			"AND p.idPessoa NOT IN (SELECT p.idPessoa FROM Usuario u " + 
			"INNER JOIN u.pessoa u)")		
	public List<Pessoa> pesquisarUsuarioNaoCadastradoPorCpf(@Param("cpf") String cpf);
	 
	
}
	
