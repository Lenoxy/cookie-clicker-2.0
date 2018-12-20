package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.*;
import application.CookieClicker;

public class MainController{
	
	double cookieCounter;
	int addToCookieCounter = 1;
	
    Timer timer = new Timer();
    TimerTask timerTask;
	
    UpgradeObject microwaveObj = new UpgradeObject();
    UpgradeObject oldovenObj = new UpgradeObject();
    UpgradeObject ovenObj = new UpgradeObject();
    UpgradeObject laserovenObj = new UpgradeObject();
    UpgradeObject dovenObj = new UpgradeObject();
    UpgradeObject ovenfactoryObj = new UpgradeObject();
	
	@FXML private TextField cookieTextfield = new TextField();
	
	@FXML private TextField cpsTextfield = new TextField();
	
	@FXML private Label microwaveCounter;
	@FXML private Label buyMicrowaveLabel;
	@FXML private Label sellMicrowaveLabel;
	
	@FXML private Label oldovenCounter;
	@FXML private Label buyOldovenLabel;
	@FXML private Label sellOldovenLabel;

	@FXML private Label ovenCounter;
	@FXML private Label buyOvenLabel;
	@FXML private Label sellOvenLabel;

	@FXML private Label laserovenCounter;
	@FXML private Label buyLaserovenLabel;
	@FXML private Label sellLaserovenLabel;

	@FXML private Label dovenCounter;
	@FXML private Label buyDovenLabel;
	@FXML private Label sellDovenLabel;

	@FXML private Label ovenfactoryCounter;
	@FXML private Label buyOvenfactoryLabel;
	@FXML private Label sellOvenfactoryLabel;
	
	public void cookieTextfield(ActionEvent event) {
		cookieCounter = cookieCounter +  addToCookieCounter;
		setTextfield(cookieTextfield, cookieCounter, "Cookie");
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
		DecimalFormat format = new DecimalFormat("#");
		if( cookieCounter >= obj.Price) {
			 cookieCounter =  cookieCounter - obj.Price;
			obj.Counter += 1;
			setCookieCounter();
			setLabel(objectCounter, obj.Counter, obj.Name);
			obj.Price *= 1.3;
			buyObjectLabel.setText(format.format(obj.Price) + "");
			sellObjectLabel.setText(format.format(obj.Price/4) + "");
		}else {
			showError("Cookie", "buy");
		}
	}
		
	void sellUpgrade(UpgradeObject obj, Label objectCounter, Label buyObjectLabel, Label sellObjectLabel) {
		DecimalFormat format = new DecimalFormat("0");
		if(obj.Counter >= 1) {
			 cookieCounter =  cookieCounter + (obj.Price/4);
			obj.Counter -= 1;
			setCookieCounter();
			setLabel(objectCounter, obj.Counter, obj.Name);
			obj.Price /= 1.3;
			buyObjectLabel.setText(format.format(obj.Price) + "");
			sellObjectLabel.setText(format.format(obj.Price/4) + "");
		}else {
			showError(obj.Name, "sell");
		}
	}
	
	
	void setCookieCounter() {
		setTextfield(cookieTextfield,  cookieCounter, "Cookie" );
	}
	
	void showError(String message, String verb) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("You can't buy this!");
		alert.setHeaderText(null);
		alert.setContentText("Sorry, you don't have enough " + message + "s to " + verb + " this.");
		alert.showAndWait();
	}
	
	void showInformation(String title, String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
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
		
	CookieClicker.readFromFile(this);
		
	    timerTask = new TimerTask() {
	        @Override
	    	public void run(){
	        	double cps = 0;
	        	cps  += microwaveObj.Counter/4 + oldovenObj.Counter*2 + ovenObj.Counter*12 + laserovenObj.Counter*30 + dovenObj.Counter*100 + ovenfactoryObj.Counter*1000; 
	        	cookieCounter += cps;
	        	setCookieCounter();				
	        	cpsTextfield.setText(cps*2 + " Cps");
	        }
	    };
	    
	    timer.schedule(timerTask, 0, 500);

		buyMicrowaveLabel.setText(microwaveObj.Price + "");
		sellMicrowaveLabel.setText(microwaveObj.Price/4 + "");
		
		buyOldovenLabel.setText(oldovenObj.Price + "");
		sellOldovenLabel.setText(oldovenObj.Price/4 + "");
		
		ovenObj.Name = "ablbu";
		
		buyOvenLabel.setText(ovenObj.Price + "");
		sellOvenLabel.setText(ovenObj.Price/4 + "");
		
		buyLaserovenLabel.setText(laserovenObj.Price + "");
		sellLaserovenLabel.setText(laserovenObj.Price/4 + "");
		
		buyDovenLabel.setText(dovenObj.Price + "");
		sellDovenLabel.setText(dovenObj.Price/4 + "");
		
		buyOvenfactoryLabel.setText(ovenfactoryObj.Price + "");
		sellOvenfactoryLabel.setText(ovenfactoryObj.Price/4 + "");	
		
		microwaveObj.Name = "Microwave";
		microwaveObj.Price = 60;
		
		oldovenObj.Name = "Old Oven";
		oldovenObj.Price = 400;
		
		ovenObj.Name = "Oven";
		ovenObj.Price = 3000;
		
		laserovenObj.Name = "Laseroven";
		laserovenObj.Price = 20000;
		
		dovenObj.Name = "Fourdimensional Oven";
		dovenObj.Price = 100000;
		
		ovenfactoryObj.Name = "Ovenfactory";
		ovenfactoryObj.Price = 1000000;
	
	}
	
	
//Menu SAVE
	public void saveToFile(ActionEvent event) {
		CookieClicker.saveToFile(this);
		showInformation("Saved", "Game saved!");
	}
	
	public void loadSavefile(ActionEvent event) {
		CookieClicker.readFromFile(this);
		reloadLabel();
		showInformation("Loaded", "Game loaded!");
	}

	public void wipeSavefile(ActionEvent event) {
		CookieClicker.wipeSave(this);
		CookieClicker.readFromFile(this);
		reloadLabel();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Do you really want to clear your save file?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			CookieClicker.wipeSave(this);
			CookieClicker.readFromFile(this);
			reloadLabel();
			showInformation("File wiped!", "The save file was wiped successfully!");
		} else {
		}
	}
	
	
//Menu SHARE
	public void saveTo(ActionEvent event) {

	}
	
	public void loadFrom(ActionEvent event) {
		
	}
	
	
	
//Menu MISC
	public void about(ActionEvent event) {
		showInformation("About", "Cookie Clicker 2.0 by Leo Scherer");
	}
	
	public void projectPage(ActionEvent event) throws IOException {
		openWebpage("http://www.041er-blj.ch/projects/2018/cookieclicker2-0_(Leo_Scherer)/");
	}
	
	public void githubPage(ActionEvent event) {
		openWebpage("https://github.com/Lenoxy/cookie-clicker-2.0");
	}	

	public static void openWebpage(String urlString) {
	    try {
	        Desktop.getDesktop().browse(new URL(urlString).toURI());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	void reloadLabel() {
	
		setTextfield(cookieTextfield, cookieCounter, "Cookie");
		
		setLabel(microwaveCounter, microwaveObj.Counter, "Microwave");
		buyMicrowaveLabel.setText(microwaveObj.Price + "");
		sellMicrowaveLabel.setText(microwaveObj.Price/4 + "");
		
		setLabel(oldovenCounter, oldovenObj.Counter, "Old oven");
		buyOldovenLabel.setText(oldovenObj.Price + "");
		sellOldovenLabel.setText(oldovenObj.Price/4 + "");
		
		setLabel(ovenCounter, ovenObj.Counter, "Oven");
		buyOvenLabel.setText(ovenObj.Price + "");
		sellOvenLabel.setText(ovenObj.Price/4 + "");
		
		setLabel(laserovenCounter, laserovenObj.Counter, "Laseroven");
		buyLaserovenLabel.setText(laserovenObj.Price + "");
		sellLaserovenLabel.setText(laserovenObj.Price/4 + "");
		
		setLabel(dovenCounter, dovenObj.Counter, "Fourdimensional Oven");
		buyDovenLabel.setText(dovenObj.Price + "");
		sellDovenLabel.setText(dovenObj.Price/4 + "");
		
		setLabel(ovenfactoryCounter, ovenfactoryObj.Counter, "Oven");
		buyOvenfactoryLabel.setText(ovenfactoryObj.Price + "");
		sellOvenfactoryLabel.setText(ovenfactoryObj.Price/4 + "");
	}
}