package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import application.MainController;


public class CookieClicker extends Application{
	
	static MainController mainController;
	
	public static File folder = new File(System.getenv("APPDATA") + "\\cookieclicker");
	public static File file = new File (System.getenv("APPDATA") + "\\cookieclicker\\save.txt");
	
	public static String folderS = (System.getenv("APPDATA") + "\\cookieclicker");
	public static String fileS = (System.getenv("APPDATA") + "\\cookieclicker\\save.txt");
	
	public static void main(String[] args) {
		System.out.println("Application started");
		launch(args);
	
	}
	
	@Override
	//Methode lädt das Fenster
	public void start(Stage primaryStage) throws Exception{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Window.fxml"));
		Parent root = loader.load();
		mainController = loader.getController();
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Cookie Clicker 2.0");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		primaryStage.getIcons().add(new Image("file:src/res/icon.png"));
		System.out.println("Window loaded");
		
		//Autospeicherung, wenn das Programm geschlossen wird.
		primaryStage.setOnHiding(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
							saveToFile(mainController);
						System.out.println("Application closed");
						System.exit(0);
					}
				});
			}
		});
	}
	//Gernerelle Methode, um den Spielstand in das Savefile einzufügen.
	public static int saveVersion = 1;
	public static void saveToFile(MainController mainController){

		saveVersion++;
		try {
			PrintWriter outputStream = new PrintWriter(file);
			outputStream.println(saveVersion);
			outputStream.println(mainController.cookieCounter);
			outputStream.println(mainController.microwaveObj.Counter);
			outputStream.println(mainController.microwaveObj.Price);
			outputStream.println(mainController.oldovenObj.Counter);
			outputStream.println(mainController.oldovenObj.Price);
			outputStream.println(mainController.ovenObj.Counter);
			outputStream.println(mainController.ovenObj.Price);
			outputStream.println(mainController.laserovenObj.Counter);
			outputStream.println(mainController.laserovenObj.Price);
			outputStream.println(mainController.dovenObj.Counter);
			outputStream.println(mainController.dovenObj.Price);
			outputStream.println(mainController.ovenfactoryObj.Counter);
			outputStream.println(mainController.ovenfactoryObj.Price);
			
			
			outputStream.close();
			System.out.println("File saved in " + file);
			
		} catch (FileNotFoundException e) {
			System.out.println("///File could not be saved in " + file + " Error: " + e);
		}
	}
	
	//Generelle Methode, um die Version des Savefiles einzulesen und alles zu aktualisieren.
	public static void readFromFile(MainController mainController) {

		//
		//
		try {
		Scanner sc;
		sc = new Scanner(new File (fileS));
			saveVersion++;
			
			saveVersion = sc.nextInt();
			mainController.cookieCounter = sc.nextDouble();
			mainController.microwaveObj.Counter = sc.nextDouble();
			mainController.microwaveObj.Price = sc.nextDouble();
			mainController.oldovenObj.Counter = sc.nextDouble();
			mainController.oldovenObj.Price = sc.nextDouble();
			mainController.ovenObj.Counter = sc.nextDouble();
			mainController.ovenObj.Price = sc.nextDouble();
			mainController.laserovenObj.Counter = sc.nextDouble();
			mainController.laserovenObj.Price = sc.nextDouble();
			mainController.dovenObj.Counter = sc.nextDouble();
			mainController.dovenObj.Price = sc.nextDouble();
			mainController.ovenfactoryObj.Counter = sc.nextDouble();
			mainController.ovenfactoryObj.Price = sc.nextDouble();
			sc.close();
			
			mainController.reloadLabel();
			
			System.out.println("File read in " + file);
		}catch(Exception e) {
			
			System.out.println("///File in " + file + " could not be read: " + e);
		}
	
	}

	//Methode schreibt die Standardwerte in das Savefile.
	static void resetSave(MainController mainController) {
		try {
			PrintWriter outputStream = new PrintWriter(file);
			outputStream.println(saveVersion);
			outputStream.println(0);
			outputStream.println(0);
			outputStream.println(60);
			outputStream.println(0);
			outputStream.println(400);
			outputStream.println(0);
			outputStream.println(3000);
			outputStream.println(0);
			outputStream.println(20000);
			outputStream.println(0);
			outputStream.println(100000);
			outputStream.println(0);
			outputStream.println(1000000);
			outputStream.close();
			System.out.println("File wiped in " + file);
			
		} catch (FileNotFoundException e) {
			System.out.println("///File in " + file + " could not be wiped: " + e);
		}
	}	
	
	//Ueberpruefen, ob save.txt bereits exisitiert. Falls nicht, wird dieses File generiert.
	static void checkForFile() {
		if(folder.exists()) {
			System.out.println("Folder found: " + folder);
			if(file.exists()) { 
			    System.out.println("File found: " + file); 
			}else {
				System.out.println("///File could not be found in: " + folder);
				resetSave(mainController);
				System.out.println("New savefile created:" + file);	
			}
		}else {
			System.out.println("///Folder could not be found in: " + folder);
			new File(folderS).mkdirs();
				System.out.println("New folder created: " + folder);
				System.out.println("///File could not be found in: " + folder);
				resetSave(mainController);
				System.out.println("New file created: " + file);
		}
	}
}