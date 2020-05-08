package com.lpi.reserva.service.impl;

import java.util.ArrayList;

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
		privilegioRepository.saveAll(preencherLista(privilegiosDto));
		return privilegiosDto;
	}
	
	@Override
	public Privilegio preencherPrivilegio(PrivilegioDto privilegioDto) {
		Privilegio privilegio = new Privilegio();
		privilegio.setId(privilegioDto.getId());
		privilegio.setNome(privilegioDto.getNome());
		privilegio.setUrl(privilegioDto.getUrl());
		return privilegio;		
	}
	
	@Override
	public ArrayList<Privilegio> preencherLista(ArrayList<PrivilegioDto> privilegios){
		ArrayList<Privilegio> listaPrivilegio = new ArrayList<Privilegio>(); 
		for (PrivilegioDto privilegioDto : privilegios) 
			listaPrivilegio.add(preencherPrivilegio(privilegioDto));
		
		return listaPrivilegio;
	}

}