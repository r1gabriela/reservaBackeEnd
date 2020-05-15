package com.lpi.reserva.service.impl;

import java.util.ArrayList;

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
	public boolean excluir(MesaDto mesaDto) {
		try {
			mesaDto.setAtivo(false);
			mesaRepository.save(preencherMesa(mesaDto));
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

	@Override
	public MesaDto preencherMesaDto(Mesa mesa) {
		MesaDto mesaDto = new MesaDto();
		mesaDto.setIdMesa(mesa.getIdMesa());
		mesaDto.setCapacidade(mesa.getCapacidade());
		mesaDto.setLocalizacao(mesa.getLocalizacao());
		mesaDto.setAtivo(mesa.getAtivo());
		return mesaDto;
	}
	
	@Override
	public MesaDto pesquisarPorId(int idMesa) {	
		return preencherMesaDto(mesaRepository.findById(idMesa).get());
	}
	
	@Override
	public ArrayList<MesaDto> listarTodos() {
		return listarMesaDto(mesaRepository.findAll());
	}
	
	@Override
    public ArrayList<MesaDto> listarMesaDto(Iterable<Mesa> iterable) {
        ArrayList<MesaDto> listaDto = new ArrayList<>();
        for(Mesa mesa: iterable) 
            listaDto.add(preencherMesaDto(mesa));
    
        return listaDto;
    }
	
}