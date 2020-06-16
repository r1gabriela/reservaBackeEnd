package com.lpi.reserva.Controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpi.reserva.dto.MesaDto;
import com.lpi.reserva.dto.ReservaDto;
import com.lpi.reserva.service.impl.MesaServiceImpl;

@RestController
@RequestMapping(path="/mesa")
public class MesaController {

	@Autowired
	private MesaServiceImpl mesaService;

	@RequestMapping(value = "/excluir", method = RequestMethod.POST)
	public boolean excluir(@RequestBody @Valid MesaDto mesaDto) {
		return mesaService.excluir(mesaDto);
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public MesaDto salvar(@RequestBody @Valid MesaDto mesaDto) {
		return mesaService.salvar(mesaDto);
	}
	
	@RequestMapping(value="/listarTodos", method = RequestMethod.GET)
	public ArrayList<MesaDto> listarTodos(){
	    return mesaService.listarTodos();
	}
	
	@RequestMapping(value = "/verDisponibilidadeMesa", method = RequestMethod.POST)
	public ArrayList<MesaDto> verDisponibilidadeMesa(@RequestBody @Valid ReservaDto reservaDto){
		return mesaService.verDisponibilidadeMesa(reservaDto);
	}
	
}