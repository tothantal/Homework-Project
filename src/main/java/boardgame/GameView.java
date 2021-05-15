package boardgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The View part of the MVC architecture
 */
public class GameView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("board.fxml"));

        Scene scene = new Scene(root, 300, 275);

        stage.setTitle("FXML");
        stage.setScene(scene);
        stage.show();
    }
}
