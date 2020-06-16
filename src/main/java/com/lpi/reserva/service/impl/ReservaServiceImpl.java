package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.PessoaRepository;
import com.lpi.reserva.Repository.ReservaRepository;
import com.lpi.reserva.Repository.UsuarioRepository;
import com.lpi.reserva.dto.ClienteDto;
import com.lpi.reserva.dto.ReservaDto;
import com.lpi.reserva.entity.Reserva;
import com.lpi.reserva.entity.Usuario;
import com.lpi.reserva.service.ReservaService;
import com.lpi.reserva.service.SecurityService;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private SecurityServiceImpl securityServiceImpl;

	public ReservaServiceImpl(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}
	
	@Override
	public ReservaDto salvar(ReservaDto reservaDto) {
		try {
			ClienteDto clienteDto = new ClienteDto();
	
			clienteDto.setIdPessoa(pessoaRepository.pesquisarIdPessoaPorLogin(securityServiceImpl.findLoggedInUsername()));
			reservaDto.setCliente(clienteDto);
			
			Reserva reserva = reservaRepository.save(new ModelMapper().map(reservaDto, Reserva.class));
			return new ModelMapper().map(reserva, ReservaDto.class);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}
	

	@Override
	public boolean excluir(int idReserva) {
		try {
			Reserva reserva = reservaRepository.findById(idReserva).get();
			reserva.setAtivo(false);
			reservaRepository.save(reserva);
			return true;
		}catch(Exception e){
		     e.printStackTrace(); 
		     return false;
		}
	}
	
	@Override
	public ArrayList<ReservaDto> listarReservas() {
		Usuario usuario = usuarioRepository.pesquisarUsuarioPorLogin(securityService.findLoggedInUsername());
		
		if(usuario.getRole().getNome().equals("funcionario"))
			return new ModelMapper().map(reservaRepository.findAll(), new TypeToken<ArrayList<ReservaDto>>() {}.getType());
			
		return new ModelMapper().map(reservaRepository.pesquisarReservaPorCliente(usuario.getPessoa().getIdPessoa()), new TypeToken<ArrayList<ReservaDto>>() {}.getType());
	}
	
}