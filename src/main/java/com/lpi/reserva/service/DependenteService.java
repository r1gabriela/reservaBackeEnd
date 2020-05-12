package com.lpi.reserva.service;

import java.util.ArrayList;

import com.lpi.reserva.dto.DependenteDto;
import com.lpi.reserva.dto.PessoaDto;
import com.lpi.reserva.entity.Cliente;
import com.lpi.reserva.entity.Dependente;

public interface DependenteService {

	public DependenteDto salvar(DependenteDto dependeteDto);

	boolean excluir(Integer idPessoa);

	public ArrayList<PessoaDto> listarPessoas(Cliente cliente);

	public DependenteDto preencherDependenteDto(Dependente dependente);

	public ArrayList<PessoaDto> listarPessoasDeCliente(int idCliente);

}