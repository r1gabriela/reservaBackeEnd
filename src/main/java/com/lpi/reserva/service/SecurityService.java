package com.lpi.reserva.service;

public interface SecurityService {

	public String findLoggedInUsername();

    public void autoLogin(String login, String senha);
	
}
