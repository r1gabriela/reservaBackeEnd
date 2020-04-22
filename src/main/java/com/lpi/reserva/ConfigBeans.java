package com.lpi.reserva;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lpi.reserva.Repository.ClienteRepository;
import com.lpi.reserva.Repository.MesaRepository;
import com.lpi.reserva.Repository.TipoComemoracaoRepository;
import com.lpi.reserva.service.ClienteService;
import com.lpi.reserva.service.MesaService;
import com.lpi.reserva.service.TipoComemoracaoService;
import com.lpi.reserva.service.impl.ClienteServiceImpl;
import com.lpi.reserva.service.impl.MesaServiceImpl;
import com.lpi.reserva.service.impl.TipoComemoracaoServiceImpl;

@Configuration
public class ConfigBeans {
	
	@Bean
    public TipoComemoracaoService initializeTipoComemoracaoService(TipoComemoracaoRepository tipoComemoracaoRepository) {
		final TipoComemoracaoService tipoComemoracaoService = new TipoComemoracaoServiceImpl(tipoComemoracaoRepository);
        return tipoComemoracaoService;
    }
	
	@Bean
	public MesaService initializeMesaService(MesaRepository mesaRepository) {
		final MesaService mesaService = new MesaServiceImpl(mesaRepository);
	    return mesaService;
	}
	
	@Bean
	public ClienteService initializeClienteService(ClienteRepository clienteRepository) {
		final ClienteService clienteService = new ClienteServiceImpl(clienteRepository);
		return clienteService;
	}
	
}
