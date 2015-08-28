package projekt;

import javafx.application.Application;
import javafx.stage.Stage;
import projekt.controller.ScreenController;

public class MainApplication extends Application {
    public static final String TITLE = "Scratcherz";
    public static final String PATH_PLAYER_IMAGES = "projekt/data/img/player/";
    // default 5
    public static final int NUM_ROUNDS = 2;
    // default 3
    public static final int NUM_QUESTIONS_PER_ROUND = 1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        ScreenController.setPrimaryStage(primaryStage);
        ScreenController.showLoginView();
    }
}
