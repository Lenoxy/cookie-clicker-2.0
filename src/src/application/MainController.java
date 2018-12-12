package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

public class MainController{
	public static int microwave = 0, oldoven = 0, oven = 0, laseroven = 0, doven = 0, ovenfactory = 0; 
	static int microwavePrice = 10;
	static int oldovenPrice = 20;
	static int ovenPrice =  30;
	static int laserovenPrice = 40;
	static int dovenPrice = 50;
	static int ovenfactoryPrice = 60;
	
	@FXML 
	private Label cookieLabel;
	@FXML 
	static private Label buyMicrowaveLabel;
	@FXML 
	static private Label sellMicrowaveLabel;
	@FXML 
	private Label microwaveCounter;
	@FXML
	static private Label buyOldovenLabel;
	@FXML
	static private Label sellOldovenLabel;
	@FXML
	private Label oldovenCounter;
	@FXML
	private Label ovenCounter;
	@FXML
	static private Label buyOvenLabel;
	@FXML
	static private Label sellOvenLabel;
	@FXML
	private Label laserovenCounter;
	@FXML
	static private Label buyLaserovenLabel;
	@FXML
	static private Label sellLaserovenLabel;
	@FXML
	private Label dovenCounter;
	@FXML
	static private Label buyDovenLabel;
	@FXML
	static private Label sellDovenLabel;
	@FXML
	private Label ovenfactoryCounter;
	@FXML
	static private Label buyOvenfactoryLabel;
	@FXML
	static private Label sellOvenfactoryLabel;
	
	

	

	
	public void cookie(ActionEvent event) {
		cookieClick();
		//Animationen Einfügen, Partikeleffekte etc.
	}
	
	
	
	public void buyMicrowave(ActionEvent event) {
		if(CookieClicker.cookieCounter >= microwavePrice) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter - microwavePrice;
			microwave = microwave + 1;
			setCookieCounter();
			setLabel(microwaveCounter, microwave, "Microwave");
		}else {
			showBuyError("Microwave");
		}
	}
	
	public void sellMicrowave(ActionEvent event) {
		if(microwave>= 1) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter + (microwavePrice/2);
			microwave = microwave - 1;
			setCookieCounter();
			setLabel(microwaveCounter, microwave, "Microwave");
		}else {
			showSellError("Microwaves");
		}
	}
	
	public void buyOldoven(ActionEvent event) {
		if(CookieClicker.cookieCounter >= oldovenPrice) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter - oldovenPrice;
			oldoven = oldoven + 1;
			setCookieCounter();
			setLabel(oldovenCounter, oldoven, "Old oven");
		}else {
			showBuyError("Old oven");
		}
	}
	
	public void sellOldoven(ActionEvent event) {
		if(oldoven>= 1) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter + (oldovenPrice/2);
			oldoven = oldoven - 1;
			setCookieCounter();
			setLabel(oldovenCounter, oldoven, "oldoven");
		}else {
			showSellError("Old oven");
		}
	}
	
	public void buyOven(ActionEvent event) {
		if(CookieClicker.cookieCounter >= ovenPrice) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter - ovenPrice;
			oven = oven + 1;
			setCookieCounter();
			setLabel(ovenCounter, oven, "oven");
		}else {
			showBuyError("Oven");
		}
	}
	
	public void sellOven(ActionEvent event) {
		if(oven>= 1) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter + (ovenPrice/2);
			oven = oven - 1;
			setCookieCounter();
			setLabel(ovenCounter, oven, "oven");
		}else {
			showSellError("Oven");
		}
	}
	
	public void buyLaseroven(ActionEvent event) {
		if(CookieClicker.cookieCounter >= laserovenPrice) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter - laserovenPrice;
			laseroven = laseroven + 1;
			setCookieCounter();
			setLabel(laserovenCounter, laseroven, "laseroven");
		}else {
			showBuyError("Laseroven");
		}
	}
	
	public void sellLaseroven(ActionEvent event) {
		if(laseroven>= 1) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter + (laserovenPrice/2);
			laseroven = laseroven - 1;
			setCookieCounter();
			setLabel(laserovenCounter, laseroven, "laseroven");
		}else {
			showSellError("laserovens");
		}
	}
	
	public void buyDoven(ActionEvent event) {
		if(CookieClicker.cookieCounter >= dovenPrice) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter - dovenPrice;
			doven = doven + 1;
			setCookieCounter();
			setLabel(dovenCounter, doven, "doven");
		}else {
			showBuyError("Fourdimensional Oven");
		}
	}
	
	public void sellDoven(ActionEvent event) {
		if(doven>= 1) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter + (dovenPrice/2);
			doven = doven - 1;
			setCookieCounter();
			setLabel(dovenCounter, doven, "doven");
		}else {
			showSellError("Fourdimensional oven");
		}
	}
	
	public void buyOvenfactory(ActionEvent event) {
		if(CookieClicker.cookieCounter >= ovenfactoryPrice) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter - ovenfactoryPrice;
			ovenfactory = ovenfactory + 1;
			setCookieCounter();
			setLabel(ovenfactoryCounter, ovenfactory, "ovenfactory");
		}else {
			showBuyError("Ovenfactory");
		}
	}

	public void sellOvenfactory(ActionEvent event) {
		if(ovenfactory>= 1) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter + (ovenfactoryPrice/2);
			ovenfactory = ovenfactory - 1;
			setCookieCounter();
			setLabel(ovenfactoryCounter, ovenfactory, "ovenfactory");
		}else {
			showSellError("ovenfactorys");
		}
	}
	


	void cookieClick() {
		CookieClicker.cookieCounter = CookieClicker.cookieCounter + CookieClicker.addToCookieCounter;
		setCookieCounter();
	}
	
	void setCookieCounter() {
		setLabel(cookieLabel, CookieClicker.cookieCounter, "Cookie");
	}
	
	void showBuyError(String message) {
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
	
	void setLabel(Label l, int number, String text) {
		
		if(number != 1) {
			l.setText(number + " " + text + "s");
		}else {
			l.setText(number + " " + text);
		}
	}
	
	
}



	

