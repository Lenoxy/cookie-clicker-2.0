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
import model.*;

public class MainController{
	
    Timer timer = new Timer();
    TimerTask timerTask;
	
    UpgradeObject microwaveObj = new UpgradeObject();
    UpgradeObject oldovenObj = new UpgradeObject();
    UpgradeObject ovenObj = new UpgradeObject();
    UpgradeObject laserovenObj = new UpgradeObject();
    UpgradeObject dovenObj = new UpgradeObject();
    UpgradeObject ovenfactoryObj = new UpgradeObject();
	
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
		buyUpgrade(microwaveObj, microwaveCounter, buyMicrowaveLabel, sellMicrowaveLabel);
	}
	
	public void sellMicrowave(ActionEvent event) {
		sellUpgrade(microwaveObj, microwaveCounter, buyMicrowaveLabel, sellMicrowaveLabel);

	}
	
	public void buyOldoven(ActionEvent event) {
		buyUpgrade(oldovenObj, oldovenCounter, buyOldovenLabel, sellOldovenLabel);

	}
	
	public void sellOldoven(ActionEvent event) {
		sellUpgrade(oldovenObj, oldovenCounter, buyOldovenLabel, sellOldovenLabel);
	}
	
	public void buyOven(ActionEvent event) {
		buyUpgrade(ovenObj, ovenCounter, buyOvenLabel, sellOvenLabel);
	}
	
	public void sellOven(ActionEvent event) {
		sellUpgrade(ovenObj, ovenCounter, buyOvenLabel, sellOvenLabel);
	}
	
	public void buyLaseroven(ActionEvent event) {
		buyUpgrade(laserovenObj, laserovenCounter, buyLaserovenLabel, sellLaserovenLabel);
	}
	
	public void sellLaseroven(ActionEvent event) {
		sellUpgrade(laserovenObj, laserovenCounter, buyLaserovenLabel, sellLaserovenLabel);

	}
	
	public void buyDoven(ActionEvent event) {
		buyUpgrade(dovenObj, dovenCounter, buyDovenLabel, sellDovenLabel);
	}
	
	public void sellDoven(ActionEvent event) {
		sellUpgrade(dovenObj, dovenCounter, buyDovenLabel, sellDovenLabel);
	}
	
	public void buyOvenfactory(ActionEvent event) {
		buyUpgrade(ovenfactoryObj, ovenfactoryCounter, buyOvenfactoryLabel, sellOvenfactoryLabel);
	}

	public void sellOvenfactory(ActionEvent event) {
		sellUpgrade(ovenfactoryObj, ovenfactoryCounter, buyOvenfactoryLabel, sellOvenfactoryLabel);
	}
	
	void buyUpgrade(UpgradeObject obj, Label objectCounter, Label buyObjectLabel, Label sellObjectLabel) {
		if(CookieClicker.cookieCounter >= obj.Price) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter - obj.Price;
			obj.Counter += 1;
			setCookieCounter();
			setLabel(objectCounter, obj.Counter, obj.Name);
			obj.Price += 10;
			buyObjectLabel.setText(obj.Price + "");
			sellObjectLabel.setText(obj.Price/4 + "");
		}else {
			showBuyError(obj.Name);
		}
	}
	
	
	double sellUpgradeOLD(double object, String name, double objectPrice, Label objectCounter, Label buyObjectLabel, Label sellObjectLabel) {
		if(object>= 1) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter + (objectPrice/4);
			object = object - 1;
			setCookieCounter();
			setLabel(objectCounter, object, name);
			objectPrice = objectPrice-10;
			buyObjectLabel.setText(objectPrice + "");
			sellObjectLabel.setText(objectPrice/4 + "");
		}else {
			showSellError(name);
		}
		
		
		return object;
	}
	void sellUpgrade(UpgradeObject obj, Label objectCounter, Label buyObjectLabel, Label sellObjectLabel) {
		if(obj.Counter >= 1) {
			CookieClicker.cookieCounter = CookieClicker.cookieCounter + (obj.Price/4);
			obj.Counter -= 1;
			setCookieCounter();
			setLabel(objectCounter, obj.Counter, obj.Name);
			obj.Price -= 10;
			buyObjectLabel.setText(obj.Price + "");
			sellObjectLabel.setText(obj.Price/4 + "");
		}else {
			showBuyError(obj.Name);
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
		
		microwaveObj.Name = "Microwave";
		microwaveObj.Price = 20;
		
		oldovenObj.Name = "Old Oven";
		oldovenObj.Price = 30;
		
		ovenObj.Name = "Oven";
		ovenObj.Price = 40;
		
		laserovenObj.Name = "Laseroven";
		laserovenObj.Price = 50;
		
		dovenObj.Name = "Fourdimensional Oven";
		dovenObj.Price = 60;
		
		ovenfactoryObj.Name = "Ovenfactory";
		ovenfactoryObj.Price = 70;
		
	    timerTask = new TimerTask() {
	        @Override
	    	public void run(){
			       CookieClicker.cookieCounter = CookieClicker.cookieCounter + microwaveObj.Counter/40;
			       CookieClicker.cookieCounter = CookieClicker.cookieCounter + oldovenObj.Counter/20;
			       CookieClicker.cookieCounter = CookieClicker.cookieCounter + ovenObj.Counter/10;
			       CookieClicker.cookieCounter = CookieClicker.cookieCounter + laserovenObj.Counter*2;
			       CookieClicker.cookieCounter = CookieClicker.cookieCounter + dovenObj.Counter*20;
			       CookieClicker.cookieCounter = CookieClicker.cookieCounter + ovenfactoryObj.Counter*100;
			       setCookieCounter();
			    }
	    };
	    timer.schedule(timerTask, 0, 100);
			
			 


		buyMicrowaveLabel.setText(microwaveObj.Price + "");
		sellMicrowaveLabel.setText(microwaveObj.Price/4 + "");
		
		buyOldovenLabel.setText(oldovenObj.Price + "");
		sellOldovenLabel.setText(oldovenObj.Price/4 + "");
		
		buyOvenLabel.setText(ovenObj.Price + "");
		sellOvenLabel.setText(ovenObj.Price/4 + "");
		
		buyLaserovenLabel.setText(laserovenObj.Price + "");
		sellLaserovenLabel.setText(laserovenObj.Price/4 + "");
		
		buyDovenLabel.setText(dovenObj.Price + "");
		sellDovenLabel.setText(dovenObj.Price/4 + "");
		
		buyOvenfactoryLabel.setText(ovenfactoryObj.Price + "");
		sellOvenfactoryLabel.setText(ovenfactoryObj.Price/4 + "");
		
	}
	
}



	

