package com.lpi.reserva.Controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpi.reserva.dto.PrivilegioDto;
import com.lpi.reserva.service.impl.PrivilegioServiceImpl;

@RestController
@RequestMapping(path="/privilegio")
public class PrivilegioController {

	@Autowired
	private PrivilegioServiceImpl privilegioService;
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ArrayList<PrivilegioDto> salvar(@RequestBody @Valid ArrayList<PrivilegioDto> arrayList) throws Exception{
		return privilegioService.salvar(arrayList);
	}
	
}