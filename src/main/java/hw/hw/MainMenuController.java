package hw.hw;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Parent;

public class MainMenuController {

	
	@FXML
	private Button startButton;
	
	@FXML
	private Button scoreButton;
	
	@FXML
	private TextField playerField;
	
	@FXML
	private Label nameLabel;
	
	@FXML
	private void launchGame() throws IOException {
		
		if (!playerField.getText().isEmpty()) {
			
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("board.fxml"));
	        Parent root = loader.load();
	         
	        BoardController boardController = loader.getController();
	        
	        boardController.transferMessage(playerField.getText());
			
			App.setRoot("board");
		}
		
		
	}
	
	@FXML
	private void showScore() throws IOException {
		App.setRoot("score");
	}
	
}
