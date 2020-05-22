package com.lpi.reserva.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.ReservaRepository;
import com.lpi.reserva.dto.ReservaDto;
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
			Reserva reserva = new Reserva();
		try {
			reserva = reservaRepository.save(new ModelMapper().map(reservaDto, Reserva.class));
			return new ModelMapper().map(reserva, ReservaDto.class);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}

	@Override
	public ReservaDto pesquisarPorId(int idReserva) {
		return new ModelMapper().map(reservaRepository.findById(idReserva).get(), ReservaDto.class);
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