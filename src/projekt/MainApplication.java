package projekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    public static final String PATH_PLAYER_IMAGES = "projekt/data/img/player/";

    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Scratcherz");
        loadLoginView();
    }

    private void loadLoginView() throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/LoginScreen.fxml"))));
        primaryStage.show();
    }

    private void loadFindGameView() throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/FindGame.fxml"))));
        primaryStage.show();
    }

}
