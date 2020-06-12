package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.MesaRepository;
import com.lpi.reserva.dto.MesaDto;
import com.lpi.reserva.dto.ReservaDto;
import com.lpi.reserva.entity.Mesa;
import com.lpi.reserva.service.MesaService;

@Service
public class MesaServiceImpl implements MesaService {

	@Autowired
	private MesaRepository mesaRepository;
	
	public MesaServiceImpl(MesaRepository mesaRepository) {
		this.mesaRepository = mesaRepository;
	}

	@Override
	public boolean excluir(MesaDto mesaDto) {
		try {
			mesaDto.setAtivo(false);
			mesaRepository.save(new ModelMapper().map(mesaDto, Mesa.class));
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public MesaDto salvar(MesaDto mesaDto) {
		try {
			Mesa mesa = mesaRepository.save(new ModelMapper().map(mesaDto, Mesa.class));
			return new ModelMapper().map(mesa, MesaDto.class);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}
	
	@Override
	public ArrayList<MesaDto> listarTodos() {
		return new ModelMapper().map(mesaRepository.findAll(), new TypeToken<ArrayList<MesaDto>>() {}.getType());
	}
	
	@Override
	public ArrayList<MesaDto> verDisponibilidadeMesa(ReservaDto reservaDto) {
		return new ModelMapper().map(mesaRepository.verDisponibilidadeMesa(reservaDto.getHoraEntrada(), reservaDto.getHoraSaida(), reservaDto.getCapacidade()), new TypeToken<ArrayList<MesaDto>>() {}.getType());
	}
	
}