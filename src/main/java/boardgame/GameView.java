package boardgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The View part of the MVC architecture
 */
public class GameView extends Application {

    private BorderPane layout;
    private Scene scene;

    public void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        layout = new BorderPane();
        scene = new Scene(layout, 450, 80);

        Button button = new Button("B");

        stage.setTitle("FXML");
        stage.setScene(scene);
        stage.show();
    }
}
