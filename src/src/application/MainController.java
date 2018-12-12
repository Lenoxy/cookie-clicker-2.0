package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

public class MainController{
	public static int microwave = 0, oldoven = 0, oven = 0, laseroven = 0, doven = 0, ovenfactory = 0; 
	int microwavePrice = 60;
	int oldovenPrice = 250;
	int ovenPrice =  1500;
	int laserovenPrice = 10000;
	int dovenPrice = 75000;
	int ovenfactoryPrice = 200000;
	
	
	
	@FXML 
	private Label cookieLabel;
	private Label buyMicrowaveLabel;
	private Label sellMicrowaveLabel;
	private Label microwaveCounter;
	
	public void cookie(ActionEvent event) {
		cookieClick();
		//Animationen Einfügen, Partikeleffekte etc.
	}
	
	
	
	public void buyMicrowave(ActionEvent event) {
		if(CookieClicker.cookieCounter >= microwavePrice) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter - microwavePrice;
			microwave = microwave + 1;
			setCookieCounter();
			
			
		}else {
			showCookieError("Microwave");
		}
	}
	
	public void sellMicrowave(ActionEvent event) {
		if(microwave>= 1) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter + (microwavePrice/2);
			microwave = microwave - 1;
			setCookieCounter();
			microwaveCounter.setText(microwave + "Microwaves");
		}else {
			showSellError("Microwaves");
		}
	}
	
	public void buyOldoven(ActionEvent event) {
		if(CookieClicker.cookieCounter >= oldovenPrice) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter - oldovenPrice;
			oldoven =+ 1;
			setCookieCounter();
			
		}else {
			showCookieError("Old Oven");
		}
	}
	
	public void sellOldoven(ActionEvent event) {
		
	}
	
	public void buyOven(ActionEvent event) {
		if(CookieClicker.cookieCounter >= ovenPrice) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter - ovenPrice;
			oven =+ 1;
			setCookieCounter();
			
		}else {
			showCookieError("Oven");
		}
	}
	
	public void sellOven(ActionEvent event) {
		
	}
	
	public void buyLaseroven(ActionEvent event) {
		if(CookieClicker.cookieCounter >= laserovenPrice) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter - laserovenPrice;
			laseroven =+ 1;
			setCookieCounter();
			
		}else {
			showCookieError("Microwave");
		}
	}
	
	public void sellLaseroven(ActionEvent event) {
		
	}
	
	public void buydOven(ActionEvent event) {
		if(CookieClicker.cookieCounter >= dovenPrice) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter - dovenPrice;
			doven =+ 1;
			setCookieCounter();
			
		}else {
			showCookieError("Fourdimensional Oven");
		}
	}
	
	public void selldOven(ActionEvent event) {
		
	}
	
	public void buyOvenfactory(ActionEvent event) {
		if(CookieClicker.cookieCounter >= ovenfactoryPrice) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter - ovenfactoryPrice;
			ovenfactoryPrice =+ 1;
			setCookieCounter();
			
		}else {
			showCookieError("Ovenfactory");
		}
	}

	public void sellOvenfactory(ActionEvent event) {
		
	}
	


	void cookieClick() {
		CookieClicker.cookieCounter = CookieClicker.cookieCounter + CookieClicker.addToCookieCounter;
		setCookieCounter();
	}
	
	void setCookieCounter() {
		if(CookieClicker.cookieCounter==1) {
			cookieLabel.setText(CookieClicker.cookieCounter + " Cookie");
		}else{
			cookieLabel.setText(CookieClicker.cookieCounter + " Cookies");
		}
	}
	
	void showCookieError(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Not enough cookies");
		alert.setHeaderText(null);
		alert.setContentText("Sorry, you currently don't have enough cookies to buy this: " + message);

		alert.showAndWait();
	}
	
	void showSellError(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Not enough " + message);
		alert.setHeaderText(null);
		alert.setContentText("Sorry, you currently don't have enough " + message + " to sell this.");

		alert.showAndWait();
	}
	
	
}



	

