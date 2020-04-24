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

}