package com.ajax.example.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("login")
public interface PasswordService extends RemoteService {

	String getData(String readUserName, String readPassword);

}
