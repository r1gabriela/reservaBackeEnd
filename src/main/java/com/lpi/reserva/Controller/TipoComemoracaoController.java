package com.lpi.reserva.Controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpi.reserva.dto.TipoComemoracaoDto;
import com.lpi.reserva.service.impl.TipoComemoracaoServiceImpl;

@RestController
@RequestMapping(path="/tipoComemoracao")
public class TipoComemoracaoController {

	@Autowired
	private TipoComemoracaoServiceImpl tipoComemoracaoService;

	@RequestMapping(value = "/excluir", method = RequestMethod.POST)
	public boolean excluir(@RequestBody TipoComemoracaoDto tipoComemoracaoDto) {
		return tipoComemoracaoService.excluir(tipoComemoracaoDto);
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public TipoComemoracaoDto salvar(@RequestBody @Valid TipoComemoracaoDto tipoComemoracaoDto) throws Exception {
			return tipoComemoracaoService.salvar(tipoComemoracaoDto);
	}	

    @RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public ArrayList<TipoComemoracaoDto> listarTodos(){
	    return tipoComemoracaoService.listarTodos();
	}
    
    @RequestMapping(value = "/listarPorAtivo", method = RequestMethod.GET)
	public ArrayList<TipoComemoracaoDto> listarPorAtivo(){
	    return tipoComemoracaoService.listarPorAtivo();
    }

}