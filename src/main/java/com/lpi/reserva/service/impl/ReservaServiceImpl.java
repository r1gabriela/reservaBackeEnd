package com.lpi.reserva.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.ReservaRepository;
import com.lpi.reserva.dto.ReservaDto;
import com.lpi.reserva.entity.Cliente;
import com.lpi.reserva.entity.Mesa;
import com.lpi.reserva.entity.Reserva;
import com.lpi.reserva.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;

	public ReservaServiceImpl(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}
	
	@Override
	public ReservaDto salvar(ReservaDto reservaDto) {
		try {
			reservaRepository.save(preencherReserva(reservaDto));
			return reservaDto;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}

	@Override
	public Reserva preencherReserva(ReservaDto reservaDto) {
		Reserva reserva = new Reserva();
		reserva.setIdReserva(reservaDto.getIdReserva());
		Cliente cliente = new Cliente();
		cliente.setIdPessoa(reservaDto.getIdCliente());
		reserva.setCliente(cliente);
		Mesa mesa = new Mesa();
		mesa.setIdMesa(reservaDto.getIdMesa());
		reserva.setMesa(mesa);
		Timestamp time = Timestamp.valueOf(reservaDto.getDataHora());
		reserva.setDataHora(time);
		reserva.setAtivo(reservaDto.getAtivo());
		return reserva;
	}

	@Override
	public ReservaDto preencherReservaDto(Reserva reserva) {
		ReservaDto reservaDto = new ReservaDto();
		reservaDto.setIdReserva(reserva.getIdReserva());
		reservaDto.setIdCliente(reserva.getCliente().getIdPessoa());
		reservaDto.setIdMesa(reserva.getMesa().getIdMesa());
		reservaDto.setDataHora(reserva.getDataHora().toString());
		reservaDto.setAtivo(reserva.getAtivo());
		return reservaDto;
	}

	@Override
	public ReservaDto pesquisarPorId(int idReserva) {
		return preencherReservaDto(reservaRepository.findById(idReserva).get());
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

}