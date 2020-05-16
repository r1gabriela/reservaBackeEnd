package com.lpi.reserva.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpi.reserva.Repository.PrivilegioRepository;
import com.lpi.reserva.dto.PrivilegioDto;
import com.lpi.reserva.entity.Privilegio;
import com.lpi.reserva.service.PrivilegioService;

@Service
public class PrivilegioServiceImpl implements PrivilegioService{
	
	
	@Autowired
	private PrivilegioRepository privilegioRepository;

	
	public PrivilegioServiceImpl(PrivilegioRepository privilegioRepository) {
		this.privilegioRepository = privilegioRepository;
	}

	@Override
	public ArrayList<PrivilegioDto> salvar(ArrayList<PrivilegioDto> privilegiosDto) {
		Iterable<Privilegio> privilegios = privilegioRepository.saveAll(preencherLista(privilegiosDto));
		return new ModelMapper().map(privilegios, new TypeToken<ArrayList<PrivilegioDto>>() {}.getType());
	}
	
	@Override
	public Privilegio preencherPrivilegio(PrivilegioDto privilegioDto) {
		Privilegio privilegio;
		try {
			privilegio = privilegioRepository.pesquisarDuplicado(privilegioDto.getNome().toLowerCase(), privilegioDto.getUrl());
			
			if(privilegio == null || privilegio.getId() == privilegioDto.getId()) {
				privilegio	= new ModelMapper().map(privilegioDto, Privilegio.class);
			}else{
				throw new Exception("Privilégio " + privilegio.getNome() + " ou URL " + privilegio.getUrl() + " ja cadastrado");
			}
			
			return privilegio;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	@Override
	public ArrayList<Privilegio> preencherLista(ArrayList<PrivilegioDto> privilegios){
		ArrayList<Privilegio> listaPrivilegio = new ArrayList<Privilegio>(); 
		for (PrivilegioDto privilegioDto : privilegios) {
			Privilegio privilegio = preencherPrivilegio(privilegioDto);
			if (privilegio != null)
				listaPrivilegio.add(privilegio);
		}
		
		return listaPrivilegio;
	}

}