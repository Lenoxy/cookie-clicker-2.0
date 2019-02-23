package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import model.*;

public class MainController{
	//Objekte und Variabeln deklarieren und initialisieren
	volatile double cookieCounter;
	private final int addToCookieCounter = 1;
	
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
	
	// Bei jedem Start ausfegührt
	@FXML
	void initialize() {
		
		CookieClicker.checkForFile();
		CookieClicker.readFromFile(this);
		
		
	    timerTask = new TimerTask() {
	        @Override
	    	public void run(){
	        	double cps = 0;
	        	cps  += microwaveObj.Counter/4 + oldovenObj.Counter*2 + ovenObj.Counter*12 + laserovenObj.Counter*30 + dovenObj.Counter*100 + ovenfactoryObj.Counter*1000; 
	        	cookieCounter += cps;
	        	updateTextInCookieTextfield();
	        	cpsTextfield.setText(cps*2 + " Cps");
	        }
	    };
	    timer.schedule(timerTask, 0, 500);
	
		microwaveObj.Name = "Microwave";
		microwaveObj.NameM = "Microwaves";

		oldovenObj.Name = "Old oven";
		oldovenObj.NameM = "Old ovens";
		
		ovenObj.Name = "Oven";
		ovenObj.NameM = "Ovens";
		
		laserovenObj.Name = "Laseroven";
		laserovenObj.NameM = "Laserovens";
		
		dovenObj.Name = "Fourdimensional Oven";
		dovenObj.NameM = "Fourdimensional Ovens";
		
		ovenfactoryObj.Name = "Ovenfactory";
		ovenfactoryObj.NameM = "Ovenfactories";
		
		setLabel(microwaveCounter, microwaveObj.Counter, microwaveObj.Name, microwaveObj.NameM);
		buyMicrowaveLabel.setText(microwaveObj.Price + "");
		sellMicrowaveLabel.setText(microwaveObj.Price/4 + "");
		
		setLabel(oldovenCounter, oldovenObj.Counter, oldovenObj.Name, oldovenObj.NameM);
		buyOldovenLabel.setText(oldovenObj.Price + "");
		sellOldovenLabel.setText(oldovenObj.Price/4 + "");
		
		setLabel(ovenCounter, ovenObj.Counter, ovenObj.Name, ovenObj.NameM);
		buyOvenLabel.setText(ovenObj.Price + "");
		sellOvenLabel.setText(ovenObj.Price/4 + "");
		
		setLabel(laserovenCounter, laserovenObj.Counter, laserovenObj.Name, laserovenObj.NameM);
		buyLaserovenLabel.setText(laserovenObj.Price + "");
		sellLaserovenLabel.setText(laserovenObj.Price/4 + "");
		
		setLabel(dovenCounter, dovenObj.Counter, dovenObj.Name, dovenObj.NameM);
		buyDovenLabel.setText(dovenObj.Price + "");
		sellDovenLabel.setText(dovenObj.Price/4 + "");
		
		setLabel(ovenfactoryCounter, ovenfactoryObj.Counter, ovenfactoryObj.Name, ovenfactoryObj.NameM);
		buyOvenfactoryLabel.setText(ovenfactoryObj.Price + "");
		sellOvenfactoryLabel.setText(ovenfactoryObj.Price/4 + "");	
		
		System.out.println("Variables Initialized");
		
	}
	
	//(JAVAFX) Die Button-Clicks im UI werden hier abgefangen.
	public void cookieClicked () {
		cookieCounter +=  addToCookieCounter;
		updateTextInCookieTextfield();
	}

	public void buyMicrowave() {
		buyUpgrade(microwaveObj, microwaveCounter, buyMicrowaveLabel, sellMicrowaveLabel);
	}

	public void sellMicrowave() {
		sellUpgrade(microwaveObj, microwaveCounter, buyMicrowaveLabel, sellMicrowaveLabel);
	}
	
	public void buyOldoven() {
		buyUpgrade(oldovenObj, oldovenCounter, buyOldovenLabel, sellOldovenLabel);
	}
	
	public void sellOldoven() {
		sellUpgrade(oldovenObj, oldovenCounter, buyOldovenLabel, sellOldovenLabel);
	}
	
	public void buyOven() {
		buyUpgrade(ovenObj, ovenCounter, buyOvenLabel, sellOvenLabel);
	}
	
	public void sellOven() {
		sellUpgrade(ovenObj, ovenCounter, buyOvenLabel, sellOvenLabel);
	}
	
	public void buyLaseroven() {
		buyUpgrade(laserovenObj, laserovenCounter, buyLaserovenLabel, sellLaserovenLabel);
	}
	
	public void sellLaseroven() {
		sellUpgrade(laserovenObj, laserovenCounter, buyLaserovenLabel, sellLaserovenLabel);
	}
	
	public void buyDoven() {
		buyUpgrade(dovenObj, dovenCounter, buyDovenLabel, sellDovenLabel);
	}
	
	public void sellDoven() {
		sellUpgrade(dovenObj, dovenCounter, buyDovenLabel, sellDovenLabel);
	}
	
	public void buyOvenfactory() { buyUpgrade(ovenfactoryObj, ovenfactoryCounter, buyOvenfactoryLabel, sellOvenfactoryLabel); }

	public void sellOvenfactory() { sellUpgrade(ovenfactoryObj, ovenfactoryCounter, buyOvenfactoryLabel, sellOvenfactoryLabel); }
	
	
	//Methode, die beim Kauf eines Upgrades aufgerufen wird.
	private void buyUpgrade(UpgradeObject obj, Label objectCounter, Label buyObjectLabel, Label sellObjectLabel) {
		DecimalFormat format = new DecimalFormat("#");
		if( cookieCounter >= obj.Price) {
			 cookieCounter =  cookieCounter - obj.Price;
			obj.Counter += 1;
			updateTextInCookieTextfield();
			setLabel(objectCounter, obj.Counter, obj.Name, obj.NameM);
			obj.Price *= 1.3;
			buyObjectLabel.setText(format.format(obj.Price) + "");
			sellObjectLabel.setText(format.format(obj.Price/4) + "");
			System.out.println(obj + " bought");
		}else {
			showError("Cookie", "buy");
			System.err.println("///" + obj + " could not be bought");
		}
	}
	//Methode, die beim Verkauf eines Upgrades aufgerufen wird.
	private void sellUpgrade(UpgradeObject obj, Label objectCounter, Label buyObjectLabel, Label sellObjectLabel) {
		DecimalFormat format = new DecimalFormat("0");
		if(obj.Counter >= 1) {
			 cookieCounter =  cookieCounter + (obj.Price/4);
			obj.Counter -= 1;
			updateTextInCookieTextfield();
			setLabel(objectCounter, obj.Counter, obj.Name, obj.NameM);
			obj.Price /= 1.3;
			buyObjectLabel.setText(format.format(obj.Price) + "");
			sellObjectLabel.setText(format.format(obj.Price/4) + "");
			System.out.println(obj + " sold");
		}else {
			showError(obj.Name, "sell");
			System.err.println("///" + obj + " could not be sold");
		}
	}
	
	//Methode zeigt eine Fehlermeldung an.
	private void showError(String message, String verb) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("You can't buy this!");
		alert.setHeaderText(null);
		alert.setContentText("Sorry, you don't have enough " + message + "s to " + verb + " this.");
		System.out.println("Error shown");
		alert.showAndWait();
	}
	
	//Methode zeigt eine Information an.
	private void showInformation(String title, String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		System.out.println("Information shown");
		alert.showAndWait();
	}
	
	//Methode setzt Labels und achtet dabei auf Ein- und Mehrzahl.
	private void setLabel(Label label, double number, String text, String textM) {
		DecimalFormat format = new DecimalFormat("0.#");
			
		if(number != 1) {
			label.setText(format.format(number) + " " + textM);
		}else {
			label.setText(format.format(number) + " " + text);
		}
	}
	
	//Methode setzt Textfields und achtet dabei auf Ein- und Mehrzahl.
	private synchronized void updateTextInCookieTextfield() {

		DecimalFormat format = new DecimalFormat("0.#");
		if(cookieCounter != 1) {
			cookieTextfield.setText(format.format(cookieCounter) + " " + "Cookies");
		}else {
			cookieTextfield.setText(format.format(cookieCounter) + " " + "Cookie");
		}
	}


//Menu SAVE
	//Methode fügt die aktuellen Daten in den Savefile ein.
	public void saveToFile() {
		CookieClicker.saveToFile(this);
		showInformation("Saved", "Game saved!");
	}
	
	//Methode liest aus dem Savefile und ueberschreibt die "alten" Werte. 
	public void loadSavefile() {
		CookieClicker.readFromFile(this);
		reloadLabel();
		showInformation("Loaded", "Game loaded!");
	}

	//Methode löscht den gesamten Speicherstand, aktualisiert die Werte und trägt im Savefile wieder die neuen Werte ein.
	public void wipeSavefile() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Do you really want to clear your save file?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			CookieClicker.resetSave(this);
			CookieClicker.readFromFile(this);
			reloadLabel();
			showInformation("Reset successful", "The reset was performed successfully");
		} else {
			//Ausgeführt, falls das löschen misslingt oder der Vorgang abgebrochen wird.
		}
	}


//Menu Leaderboard
	//Methode schreibt den aktuellen Score in die Datenbank im Internet.
	public void saveToLeaderboard() {
		TextInputDialog dialog = new TextInputDialog("Name");
		dialog.setTitle("Leaderboard");
		dialog.setHeaderText(null);
		dialog.setContentText("Please enter your name:");
		
		try {	
			Optional<String> result = dialog.showAndWait();
			String nameOfPlayer = "?";
			if (result.isPresent()) {
				nameOfPlayer = result.get();
				boolean insertComplete = SqlController.insert(nameOfPlayer, cookieCounter);
				if(insertComplete) {
					showInformation("Data inserted!", "Your data was uploaded successfully!");
					System.out.println("Data inserted successfully");
				}else {
					showInformation("Data could not be inserted", "Check your connection and enter a name with maximum 20 characters");
					System.err.println("///Error while inserting data");
				}
			}else {
				showInformation("Mr. Noname", "You have to enter a name!");
				System.err.println("///Error: You have to enter a name");
			}
		}catch(Exception e){
			System.err.println("///Database error: " + e);
		}	
	}
	
	//Methode oeffnet das Leaderboard im Standardbrowser
	public void viewLeaderboard() {
		openWebpage(SQL.HRwebpage);
	}


//Menu MISC
	//Methode oeffnet ein Dialog mit den Informationen des Programmes.
	public void about() {
		showInformation("About", "Cookie Clicker 2.0 (Version 8.2) by Leo Scherer");
	}
	
	//Methode oeffnet die Projektseite des Basislehrjahres im Standardbrowser
	public void projectPage() throws IOException {
		openWebpage("http://www.041er-blj.ch/projects/2018/cookie_clicker_(Leo_Scherer)");
	}
	
	//Methode oeffnet die Github-Page im Standardbrowser
	public void githubPage() {
		openWebpage("https://github.com/Lenoxy/cookie-clicker-2.0");
	}	

	//Allgemeine Methode, um URIs im Standardbrowser zu öffnen.
	public static void openWebpage(String urlString) {
	    try {
	        Desktop.getDesktop().browse(new URL(urlString).toURI());
	        System.out.println(urlString + " opened");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	//Methode lädt alle Labels (+ die Textfelder) neu.
	void reloadLabel() {
	
		updateTextInCookieTextfield();
		
		setLabel(microwaveCounter, microwaveObj.Counter, microwaveObj.Name, microwaveObj.NameM);
		buyMicrowaveLabel.setText(microwaveObj.Price + "");
		sellMicrowaveLabel.setText(microwaveObj.Price/4 + "");
		
		setLabel(oldovenCounter, oldovenObj.Counter, oldovenObj.Name, oldovenObj.NameM);
		buyOldovenLabel.setText(oldovenObj.Price + "");
		sellOldovenLabel.setText(oldovenObj.Price/4 + "");
		
		setLabel(ovenCounter, ovenObj.Counter, ovenObj.Name, ovenObj.NameM);
		buyOvenLabel.setText(ovenObj.Price + "");
		sellOvenLabel.setText(ovenObj.Price/4 + "");
		
		setLabel(laserovenCounter, laserovenObj.Counter, laserovenObj.Name, laserovenObj.NameM);
		buyLaserovenLabel.setText(laserovenObj.Price + "");
		sellLaserovenLabel.setText(laserovenObj.Price/4 + "");
		
		setLabel(dovenCounter, dovenObj.Counter, dovenObj.Name, dovenObj.NameM);
		buyDovenLabel.setText(dovenObj.Price + "");
		sellDovenLabel.setText(dovenObj.Price/4 + "");
		
		setLabel(ovenfactoryCounter, ovenfactoryObj.Counter, ovenfactoryObj.Name, ovenfactoryObj.NameM);
		buyOvenfactoryLabel.setText(ovenfactoryObj.Price + "");
		sellOvenfactoryLabel.setText(ovenfactoryObj.Price/4 + "");
		
		System.out.println("Labels and Textfields reloaded");
	}
}