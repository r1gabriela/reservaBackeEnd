package com.lpi.reserva.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpi.reserva.dto.DataComemorativaDto;
import com.lpi.reserva.service.impl.DataComemorativaServiceImpl;

@RestController
@RequestMapping(path="/dataComemorativa")
public class DataComemorativaController {

	@Autowired
	private DataComemorativaServiceImpl dataComemorativaService;
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public DataComemorativaDto salvar(DataComemorativaDto dataComemorativaDto) {
		return dataComemorativaService.salvar(dataComemorativaDto);
	}
	
	@RequestMapping(value = "/pesquisarPorId", method = RequestMethod.GET)
    public DataComemorativaDto pesquisarPorId(@RequestParam(value = "idDataComemorativa") int idDataComemorativa) {
    	return dataComemorativaService.pesquisarPorId(idDataComemorativa);	
    }
	
}