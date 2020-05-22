package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.DependenteDto;
import com.lpi.reserva.dto.PessoaDto;
import com.lpi.reserva.entity.Cliente;

public interface DependenteService {

	public DependenteDto salvar(DependenteDto dependeteDto);

	boolean excluir(Integer idPessoa);

	public ArrayList<PessoaDto> listarPessoas(Cliente cliente);

	public ArrayList<PessoaDto> listarPessoasDeCliente(int idCliente);
	
//	public ArrayList<DependenteDto> listar();

}