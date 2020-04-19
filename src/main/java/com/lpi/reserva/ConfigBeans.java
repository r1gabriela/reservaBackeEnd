package com.lpi.reserva;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lpi.reserva.Repository.TipoComemoracaoRepository;
import com.lpi.reserva.service.TipoComemoracaoService;
import com.lpi.reserva.service.impl.TipoComemoracaoServiceImpl;

@Configuration
public class ConfigBeans {
	
	@Bean
    public TipoComemoracaoService initializeTipoComemoracaoService(TipoComemoracaoRepository tipoComemoracaoRepository) {
		final TipoComemoracaoService tipoComemoracaoService = new TipoComemoracaoServiceImpl(tipoComemoracaoRepository);
        return tipoComemoracaoService;
    }
	
}
