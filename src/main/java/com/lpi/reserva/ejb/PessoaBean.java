package com.lpi.reserva.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lpi.reserva.entity.Pessoa;

public class PessoaBean {

	@PersistenceContext
	private EntityManager em;
	
	public Pessoa pesquisar() {
		Pessoa pessoa = new Pessoa();
		return pessoa;
	}
	
}
