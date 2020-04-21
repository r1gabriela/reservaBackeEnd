package com.lpi.reserva.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpi.reserva.dto.TipoComemoracaoDto;
import com.lpi.reserva.service.impl.TipoComemoracaoServiceImpl;

@RestController
@RequestMapping(path="/tipoComemoracao")
public class TipoComemoracaoController {

	@Autowired
	private TipoComemoracaoServiceImpl tipoComemoracaoService;

	@RequestMapping(value = "/excluir", method = RequestMethod.GET)
	public boolean excluir(@RequestParam(value = "idTipoComemoracao") int idTipoComemoracao) {
		return tipoComemoracaoService.excluir(idTipoComemoracao);
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public TipoComemoracaoDto salvar(TipoComemoracaoDto tipoComemoracaoDto) {
		return tipoComemoracaoService.salvar(tipoComemoracaoDto);
	}	

    @RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public List<TipoComemoracaoDto> listarTodos(){
	    return tipoComemoracaoService.listarTodos();
	}
    
    @RequestMapping(value = "/pesquisarPorId", method = RequestMethod.GET)
    public TipoComemoracaoDto pesquisarPorId(@RequestParam(value = "idTipoComemoracao") int idTipoComemoracao) {
    	return tipoComemoracaoService.pesquisarPorId(idTipoComemoracao);	
    }
    
}		
		
		
	

