package hw.hw;

import boardgame.model.Highscore;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class ScoreController {

	Highscore scores = new Highscore();
	
	
	@FXML
	Label scoreText;
	
	@FXML
	private void initialize() throws IOException, JAXBException {
		
		this.scores.fromXML();
		
		this.scoreText.setText(scores.toString());
	}
	
}
