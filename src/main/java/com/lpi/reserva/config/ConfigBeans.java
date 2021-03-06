package com.lpi.reserva.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.lpi.reserva.Repository.ClienteRepository;
import com.lpi.reserva.Repository.DataComemorativaRepository;
import com.lpi.reserva.Repository.DependenteRepository;
import com.lpi.reserva.Repository.FuncionarioRepository;
import com.lpi.reserva.Repository.MesaRepository;
import com.lpi.reserva.Repository.PessoaRepository;
import com.lpi.reserva.Repository.PrivilegioRepository;
import com.lpi.reserva.Repository.ReservaRepository;
import com.lpi.reserva.Repository.RoleRepository;
import com.lpi.reserva.Repository.TipoComemoracaoRepository;
import com.lpi.reserva.Repository.UsuarioRepository;
import com.lpi.reserva.service.ClienteService;
import com.lpi.reserva.service.DataComemorativaService;
import com.lpi.reserva.service.DependenteService;
import com.lpi.reserva.service.FuncionarioService;
import com.lpi.reserva.service.MesaService;
import com.lpi.reserva.service.PessoaService;
import com.lpi.reserva.service.PrivilegioService;
import com.lpi.reserva.service.ReservaService;
import com.lpi.reserva.service.RoleService;
import com.lpi.reserva.service.TipoComemoracaoService;
import com.lpi.reserva.service.UsuarioService;
import com.lpi.reserva.service.impl.ClienteServiceImpl;
import com.lpi.reserva.service.impl.DataComemorativaServiceImpl;
import com.lpi.reserva.service.impl.DependenteServiceImpl;
import com.lpi.reserva.service.impl.FuncionarioServiceImpl;
import com.lpi.reserva.service.impl.MesaServiceImpl;
import com.lpi.reserva.service.impl.PessoaServiceImpl;
import com.lpi.reserva.service.impl.PrivilegioServiceImpl;
import com.lpi.reserva.service.impl.ReservaServiceImpl;
import com.lpi.reserva.service.impl.RoleServiceImpl;
import com.lpi.reserva.service.impl.TipoComemoracaoServiceImpl;
import com.lpi.reserva.service.impl.UserDetailsServiceImpl;
import com.lpi.reserva.service.impl.UsuarioServiceImpl;

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
	
	@Bean
	public UsuarioService initializeUsuarioService(UsuarioRepository usuarioRepository) {
		final UsuarioService usuarioService = new UsuarioServiceImpl(usuarioRepository);
		return usuarioService;
	}
	
	@Bean
	public DependenteService initializeDependenteService(DependenteRepository dependenteRepository) {
		final DependenteService dependenteService = new DependenteServiceImpl(dependenteRepository);
		return dependenteService;
	}
	
	@Bean
	public PessoaService initializePessoaService(PessoaRepository pessoaRepository) {
		final PessoaService pessoaService = new PessoaServiceImpl(pessoaRepository);
		return pessoaService;
	}
	
	@Bean
	public FuncionarioService initializeFuncionarioService(FuncionarioRepository funcionarioRepository) {
		final FuncionarioService funcionarioService = new FuncionarioServiceImpl(funcionarioRepository);
		return funcionarioService;
	}
	
	@Bean
	public ReservaService initializeReservaService(ReservaRepository reservaRepository) {
		final ReservaService reservaService = new ReservaServiceImpl(reservaRepository);
		return reservaService;
	}
	
	@Bean
	public DataComemorativaService initializeDataComemorativaService(DataComemorativaRepository dataComemorativaRepository) {
		final DataComemorativaService dataComemorativaService = new DataComemorativaServiceImpl(dataComemorativaRepository);
		return dataComemorativaService;
	}
	
	@Bean
	public UserDetailsService initializeUserDetailsService() {
		final UserDetailsService userDetailsService = new UserDetailsServiceImpl();
		return userDetailsService;
	}
	
	@Bean
	public PrivilegioService initializePrivilegioService(PrivilegioRepository privilegioRepository) {
		final PrivilegioService privilegioService = new PrivilegioServiceImpl(privilegioRepository);
		return privilegioService;
	}
	
	@Bean
	public RoleService initializeRoleService(RoleRepository roleRepository) {
		final RoleService roleService = new RoleServiceImpl(roleRepository);
		return roleService;
	}
	
}