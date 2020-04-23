package com.lpi.reserva.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpi.reserva.dto.DependenteDto;
import com.lpi.reserva.service.impl.DependenteServiceImpl;

@RestController
@RequestMapping(path="/dependente")
public class DependenteController {

	@Autowired
	private DependenteServiceImpl dependenteService;
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public DependenteDto salvar(DependenteDto dependeteDto) {
		return dependenteService.salvar(dependeteDto);
	}
	
}