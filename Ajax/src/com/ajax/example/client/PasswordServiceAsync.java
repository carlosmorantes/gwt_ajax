package com.ajax.example.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PasswordServiceAsync {

	void getData(String readUserName, String readPassword, AsyncCallback<String> callback);

}
