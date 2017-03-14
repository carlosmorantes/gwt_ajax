package com.ajax.example.server;

import java.util.Date;

import com.ajax.example.client.PasswordService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PasswordServiceImpl extends RemoteServiceServlet implements PasswordService {
	private String userName = "carlos";
	private String password = "test";
	private Date now = new Date();
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getData(String readUserName, String readPassword) {		
		if (userName.equals(readUserName) && password.equals(readPassword)){
			System.out.println("["+now+"]"+" --- Login success ---");
			return "Ok";
		}
		else{
			System.out.println("["+now+"]"+" --- Login error ---");
			return "Invalid";
		}
	}
	
	

}
