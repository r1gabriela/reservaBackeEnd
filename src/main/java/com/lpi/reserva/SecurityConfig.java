package com.lpi.reserva;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.lpi.reserva.entity.Privilegio;
import com.lpi.reserva.entity.Role;
import com.lpi.reserva.service.impl.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
	public void configure(HttpSecurity http) throws Exception { //metodo que configura a autorizacao
		ArrayList<Privilegio> privilegios = new ArrayList<>();
		
		http 
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/resources/**", "/webjars/**" , "/materialize/**" , "/style/**", "/privilegio/**").permitAll();
		
		for (Privilegio privilegio: privilegios) {
			boolean permite = false;
			for (Role role: privilegio.getRoles()) {
				if (role.getNome() == "user") {
					http
					.authorizeRequests()
					.antMatchers(privilegio.getUrl()).permitAll();
					permite = true;
					break;
				}
			}
			
			if (permite == false) 
				http
				.authorizeRequests()
				.antMatchers(privilegio.getUrl()).hasAuthority(privilegio.getNome());	
		}
		
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/resources/**", "/webjars/**" , "/materialize/**" , "/style/**", "/privilegio/**").permitAll() //libera recursos js e css
		.antMatchers("/reserva/salvar").permitAll()
		.antMatchers("/priviegio/salvar").permitAll()
		.antMatchers("/role/salvar").permitAll()
		.antMatchers("/tipoComemoracao/listarTodos").permitAll()
		.antMatchers("/tipoComemoracao/salvar").permitAll()
		.antMatchers("/tipoComemoracao/excluir").permitAll()
		.antMatchers("/usuario/logar").permitAll()
		.antMatchers("/usuario/salvar").permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
		
	@Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }
	
}
