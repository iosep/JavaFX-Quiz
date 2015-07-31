package projekt;

import javafx.application.Application;
import javafx.stage.Stage;
import projekt.controller.ScreenController;

public class MainApplication extends Application {
    public static final String PATH_PLAYER_IMAGES = "projekt/data/img/player/";

    @Override
    public void start(Stage primaryStage) throws Exception {
        ScreenController.setPrimaryStage(primaryStage);
        ScreenController.showLoginView();
    }
}
