package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class CookieClicker extends Application{
	
	
	public static int cookieCounter;
	public static int addToCookieCounter = 1;
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		Parent root = FXMLLoader.load(getClass().getResource("Window.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Cookie Clicker 2.0");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		}
}