package com.lpi.reserva.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.MesaRepository;
import com.lpi.reserva.dto.MesaDto;
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
	public boolean excluir(Integer idMesa) {
		try {
			Mesa mesa = mesaRepository.findById(idMesa).get();
			mesa.setAtivo(false);
			mesaRepository.save(mesa);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public MesaDto salvar(MesaDto mesaDto) {
		try {
			mesaRepository.save(preencherMesa(mesaDto));
			return mesaDto;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}

	@Override
	public Mesa preencherMesa(MesaDto mesaDto) {
		Mesa mesa = new Mesa();
		mesa.setIdMesa(mesaDto.getIdMesa());
		mesa.setCapacidade(mesaDto.getCapacidade());
		mesa.setLocalizacao(mesaDto.getLocalizacao());
		mesa.setAtivo(mesaDto.getAtivo());
		return mesa;
	}

}
