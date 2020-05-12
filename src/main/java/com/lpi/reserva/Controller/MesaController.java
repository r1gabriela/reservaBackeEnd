package com.lpi.reserva.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpi.reserva.dto.MesaDto;
import com.lpi.reserva.service.impl.MesaServiceImpl;

@RestController
@RequestMapping(path="/mesa")
public class MesaController {

	@Autowired
	private MesaServiceImpl mesaService;

	@RequestMapping(value = "/excluir", method = RequestMethod.GET)
	public boolean excluir(@RequestParam(value = "idMesa") int idMesa) {
		return mesaService.excluir(idMesa);
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public MesaDto salvar(@RequestBody MesaDto mesaDto) {
		return mesaService.salvar(mesaDto);
	}
	
	@RequestMapping(value = "/pesquisarPorId", method = RequestMethod.GET)
    public MesaDto pesquisarPorId(@RequestParam(value = "idMesa") int idMesa) {
    	return mesaService.pesquisarPorId(idMesa);	
    }
	
}