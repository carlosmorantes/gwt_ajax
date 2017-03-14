package com.ajax.example.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Ajax implements EntryPoint {
	
	private VerticalPanel mainPanel = new VerticalPanel();
	private HorizontalPanel addPanel = new HorizontalPanel();
	private TextBox userName = new TextBox();
	private PasswordTextBox password = new PasswordTextBox();
	private Button sendLogin = new Button("Send");

	public void onModuleLoad() {

		// Add panel

		// Assemble main panel
		mainPanel.add(userName);
		mainPanel.add(password);
		mainPanel.add(sendLogin);

		// Associate the Main panel with the HTML host page
		RootPanel.get("loginField").add(mainPanel);

		// click handler
		sendLogin.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				checkUserAndPassword();
			}

		});
	}
	
	private void checkUserAndPassword(){
		
		// Create the service proxy class
	    PasswordServiceAsync messageService = GWT.create(PasswordService.class);
	    
	    AsyncCallback<String> callback = new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Server error!");
				
			}

			@Override
			public void onSuccess(String result) {
				if (result == "Ok")
				    Window.alert("Login success!");
				else
					Window.alert("Invalid login data");
				
			}
		};
		
		// make the call to the server
		String readUserName = userName.getText();
		String readPassword = password.getText();
		
		messageService.getData(readUserName, readPassword, callback);
		
	}
}
