package application;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController{
	
    Timer timer = new Timer();
    TimerTask timerTask;
	
	
	public double microwave = 0, oldoven = 0, oven = 0, laseroven = 0, doven = 0, ovenfactory = 0; 
	
	double microwavePrice = 20;
	double oldovenPrice = 20;
	double ovenPrice =  30;
	double laserovenPrice = 40;
	double dovenPrice = 50;
	double ovenfactoryPrice = 60;
	
	@FXML 
	private TextField cookieTextfield = new TextField();
	
	@FXML 
	private Label microwaveCounter;
	@FXML 
	private Label buyMicrowaveLabel;
	@FXML 
	private Label sellMicrowaveLabel;
	
	@FXML
	private Label oldovenCounter;
	@FXML
	private Label buyOldovenLabel;
	@FXML
	private Label sellOldovenLabel;

	@FXML
	private Label ovenCounter;
	@FXML
	private Label buyOvenLabel;
	@FXML
	private Label sellOvenLabel;

	@FXML
	private Label laserovenCounter;
	@FXML
	private Label buyLaserovenLabel;
	@FXML
	private Label sellLaserovenLabel;

	@FXML
	private Label dovenCounter;
	@FXML
	private Label buyDovenLabel;
	@FXML
	private Label sellDovenLabel;

	@FXML
	private Label ovenfactoryCounter;
	@FXML
	private Label buyOvenfactoryLabel;
	@FXML
	private Label sellOvenfactoryLabel;
	
	
	public void cookieTextfield(ActionEvent event) {
		CookieClicker.cookieCounter = CookieClicker.cookieCounter + CookieClicker.addToCookieCounter;
		setTextfield(cookieTextfield, CookieClicker.cookieCounter, "Cookie");
	}
	
	
	
	public void buyMicrowave(ActionEvent event) {
		if(CookieClicker.cookieCounter >= microwavePrice) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter - microwavePrice;
			microwave = microwave + 1;
			setCookieCounter();
			setLabel(microwaveCounter, microwave, "Microwave");
			microwavePrice = microwavePrice+10;
			buyMicrowaveLabel.setText(microwavePrice + "");
			sellMicrowaveLabel.setText(microwavePrice/4 + "");
		}else {
			showBuyError("Microwave");
		}
	}
	
	public void sellMicrowave(ActionEvent event) {
		if(microwave>= 1) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter + (microwavePrice/4);
			microwave = microwave - 1;
			setCookieCounter();
			setLabel(microwaveCounter, microwave, "Microwave");
			microwavePrice = microwavePrice-10;
			buyMicrowaveLabel.setText(microwavePrice + "");
			sellMicrowaveLabel.setText(microwavePrice/4 + "");
		}else {
			showSellError("Microwave");
		}
	}
	
	public void buyOldoven(ActionEvent event) {
		if(CookieClicker.cookieCounter >= oldovenPrice) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter - oldovenPrice;
			oldoven = oldoven + 1;
			setCookieCounter();
			setLabel(oldovenCounter, oldoven, "Old oven");
			oldovenPrice = oldovenPrice+10;
			buyOldovenLabel.setText(oldovenPrice + "");
			sellOldovenLabel.setText(oldovenPrice/4 + "");
		}else {
			showBuyError("Old oven");
		}
	}
	
	public void sellOldoven(ActionEvent event) {
		if(oldoven>= 1) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter + (oldovenPrice/4);
			oldoven = oldoven - 1;
			setCookieCounter();
			setLabel(oldovenCounter, oldoven, "oldoven");
			oldovenPrice = oldovenPrice-10;
			buyOldovenLabel.setText(oldovenPrice + "");
			sellOldovenLabel.setText(oldovenPrice/4 + "");
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
			ovenPrice = ovenPrice+10;
			buyOvenLabel.setText(ovenPrice + "");
			sellOvenLabel.setText(ovenPrice/4 + "");
		}else {
			showBuyError("Oven");
		}
	}
	
	public void sellOven(ActionEvent event) {
		if(oven>= 1) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter + (ovenPrice/4);
			oven = oven - 1;
			setCookieCounter();
			setLabel(ovenCounter, oven, "oven");
			ovenPrice = ovenPrice-10;
			buyOvenLabel.setText(ovenPrice + "");
			sellOvenLabel.setText(ovenPrice/4 + "");
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
			laserovenPrice = laserovenPrice+10;
			buyLaserovenLabel.setText(laserovenPrice + "");
			sellLaserovenLabel.setText(laserovenPrice/4 + "");
		}else {
			showBuyError("Laseroven");
		}
	}
	
	public void sellLaseroven(ActionEvent event) {
		if(laseroven>= 1) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter + (laserovenPrice/4);
			laseroven = laseroven - 1;
			setCookieCounter();
			setLabel(laserovenCounter, laseroven, "laseroven");
			laserovenPrice = laserovenPrice-10;
			buyLaserovenLabel.setText(laserovenPrice + "");
			sellLaserovenLabel.setText(laserovenPrice/4 + "");
		}else {
			showSellError("Laseroven");
		}
	}
	
	public void buyDoven(ActionEvent event) {
		if(CookieClicker.cookieCounter >= dovenPrice) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter - dovenPrice;
			doven = doven + 1;
			setCookieCounter();
			setLabel(dovenCounter, doven, "doven");
			dovenPrice = dovenPrice+10;
			buyDovenLabel.setText(dovenPrice + "");
			sellDovenLabel.setText(dovenPrice/4 + "");
		}else {
			showBuyError("Fourdimensional oven");
		}
	}
	
	public void sellDoven(ActionEvent event) {
		if(doven>= 1) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter + (dovenPrice/4);
			doven = doven - 1;
			setCookieCounter();
			setLabel(dovenCounter, doven, "doven");
			dovenPrice = dovenPrice-10;
			buyDovenLabel.setText(dovenPrice + "");
			sellDovenLabel.setText(dovenPrice/4 + "");
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
			ovenfactoryPrice = ovenfactoryPrice+10;
			buyOvenfactoryLabel.setText(ovenfactoryPrice + "");
			sellOvenfactoryLabel.setText(ovenfactoryPrice/4 + "");
		}else {
			showBuyError("Ovenfactory");
		}
	}

	public void sellOvenfactory(ActionEvent event) {
		if(ovenfactory>= 1) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter + (ovenfactoryPrice/4);
			ovenfactory = ovenfactory - 1;
			setCookieCounter();
			setLabel(ovenfactoryCounter, ovenfactory, "ovenfactory");
			ovenfactoryPrice = ovenfactoryPrice-10;
			buyOvenfactoryLabel.setText(ovenfactoryPrice + "");
			sellOvenfactoryLabel.setText(ovenfactoryPrice/4 + "");
		}else {
			showSellError("Ovenfactory");
		}
	}
	
	
	void setCookieCounter() {
		setTextfield(cookieTextfield, CookieClicker.cookieCounter, "Cookie" );
	}
	
	void showBuyError(String message) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Not enough cookies");
		alert.setHeaderText(null);
		alert.setContentText("Sorry, you currently don't have enough cookies to buy this: " + message);

		alert.showAndWait();
	}
	
	void showSellError(String message) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Not enough " + message + "s");
		alert.setHeaderText(null);
		alert.setContentText("Sorry, you currently don't have enough " + message + "s to sell this.");

		alert.showAndWait();
	}
	
	void setLabel(Label label, double number, String text) {
		DecimalFormat format = new DecimalFormat("0.#");
			
		if(number != 1) {
			label.setText(format.format(number) + " " + text + "s");
		}else {
			label.setText(format.format(number) + " " + text);
		}
	}
	
	void setTextfield(TextField field, double number, String text) {
		DecimalFormat format = new DecimalFormat("0.#");
			
		if(number != 1) {
			field.setText(format.format(number) + " " + text + "s");
		}else {
			field.setText(format.format(number) + " " + text);
		}
	}
		
	@FXML
	void initialize() {
		
	    timerTask = new TimerTask() {
	        @Override
	    	public void run(){
			       CookieClicker.cookieCounter = CookieClicker.cookieCounter + microwave/40;
			       CookieClicker.cookieCounter = CookieClicker.cookieCounter + oldoven/20;
			       CookieClicker.cookieCounter = CookieClicker.cookieCounter + oven/10;
			       CookieClicker.cookieCounter = CookieClicker.cookieCounter + laseroven*2;
			       CookieClicker.cookieCounter = CookieClicker.cookieCounter + doven*20;
			       CookieClicker.cookieCounter = CookieClicker.cookieCounter + ovenfactory*100;
			       setCookieCounter();
			    }
	    };
	    timer.schedule(timerTask, 0, 100);
			
			 


		buyMicrowaveLabel.setText(microwavePrice + "");
		sellMicrowaveLabel.setText(microwavePrice/4 + "");
		
		buyOldovenLabel.setText(oldovenPrice + "");
		sellOldovenLabel.setText(oldovenPrice/4 + "");
		
		buyOvenLabel.setText(ovenPrice + "");
		sellOvenLabel.setText(ovenPrice/4 + "");
		
		buyLaserovenLabel.setText(laserovenPrice + "");
		sellLaserovenLabel.setText(laserovenPrice/4 + "");
		
		buyDovenLabel.setText(dovenPrice + "");
		sellDovenLabel.setText(dovenPrice/4 + "");
		
		buyOvenfactoryLabel.setText(ovenfactoryPrice + "");
		sellOvenfactoryLabel.setText(ovenfactoryPrice/4 + "");
		
	}
	
}



	

