package com.lpi.reserva.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpi.reserva.dto.ReservaDto;
import com.lpi.reserva.service.impl.ReservaServiceImpl;

@RestController
@RequestMapping(path="/reserva")
public class ReservaController {

	@Autowired
	private ReservaServiceImpl reservaServiceImpl;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ReservaDto salvar(@RequestBody @Valid ReservaDto reservaDto) {
		return reservaServiceImpl.salvar(reservaDto);
	}
	
	@RequestMapping(value = "/pesquisarPorId", method = RequestMethod.GET)
    public ReservaDto pesquisarPorId(@RequestParam(value = "idReserva") int idReserva) {
    	return reservaServiceImpl.pesquisarPorId(idReserva);	
    }
	
	@RequestMapping(value = "/excluir", method = RequestMethod.GET)
    public boolean excluir(@RequestParam(value = "idReserva") int idReserva) {
    	return reservaServiceImpl.excluir(idReserva);	
    }
	
}