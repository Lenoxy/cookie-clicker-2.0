package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import application.MainController;


public class CookieClicker extends Application{
	
	MainController mainController;
	
	public static void main(String[] args) {
		System.out.println("Application started");
		//readFromFile();
		launch(args);
	
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Window.fxml"));
		Parent root = loader.load();
		mainController = loader.getController();
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Cookie Clicker 2.0");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		System.out.println("Window loaded");
		
	
		
		
	
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
	public static int saveVersion = 0;
	public static void saveToFile(MainController mainController){

		saveVersion++;
		String fileName = "save.txt";
		try {
			PrintWriter outputStream = new PrintWriter(fileName);
			outputStream.println(saveVersion); //SaveVersion noch fixen
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
			System.out.println("File saved");
			
		} catch (FileNotFoundException e) {
			System.out.println("File could not be saved:");
			e.printStackTrace();
		}
	}
	
	public static void readFromFile(MainController mainController) {

		
		try {
		Scanner sc;
		sc = new Scanner(new File ("save.txt"));
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
			
			System.out.println("File read");
		}catch(Exception e) {
			
			System.out.println("File could not be read:");
			e.printStackTrace();
		}
	}
}







