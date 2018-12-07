package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
	@FXML
	private Label cookieLabel;
	
	public void cookie(ActionEvent event) {
		CookieClicker.cookieCounter++;
		cookieLabel.setText(Integer.toString(CookieClicker.cookieCounter));
		
	}
}
