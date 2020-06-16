package com.lpi.reserva.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.lpi.reserva.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
    private AuthenticationManager authenticationManager;
	
	private static Object principal;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
	
    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);
    
	@Override
	public String findLoggedInUsername() {
		Object userDetails = principal;
        
		if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }

        return null;
	}

	@Override
	public void autoLogin(String login, String senha) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(login);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, senha, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            logger.debug(String.format("Auto login %s successfully!", login));
        }
	}

}