package com.lpi.reserva.Controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
	public DataComemorativaDto salvar(@RequestBody @Valid DataComemorativaDto dataComemorativaDto) throws Exception {
		return dataComemorativaService.salvar(dataComemorativaDto);
	}
	
	@RequestMapping(value = "/excluir", method = RequestMethod.GET)
    public boolean excluir(@RequestParam(value = "idDataComemorativa") int idDataComemorativa) {
    	return dataComemorativaService.excluir(idDataComemorativa);	
    }
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ArrayList<DataComemorativaDto> listar() {
	return dataComemorativaService.listar();
	}
	
}