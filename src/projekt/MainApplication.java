package projekt;

import javafx.application.Application;
import javafx.stage.Stage;
import projekt.controller.ScreenController;

public class MainApplication extends Application {
    public static final String TITLE = "Scratcherz";
    public static final String PATH_PLAYER_IMAGES = "projekt/data/img/player/";
    public static final String PATH_HIGHSCORE = "src/projekt/data/highscore.txt";
    public static final String PATH_QUESTIONS = "src/projekt/data/questions.txt";
    public static final int NUM_ROUNDS = 4;
    public static final int NUM_QUESTIONS_PER_ROUND = 3;
    public static final int RIGHT_ANSWER_SCORE = 100;
    public static final int WRONG_ANSWER_SCORE = 50;
    public static final int NUM_QUESTION_POSSIBILITIES = 4;
    public static final int MAX_HIGHSCORE_SLOTS = 10;

    @Override
    public void start(Stage primaryStage) throws Exception {
        ScreenController.setPrimaryStage(primaryStage);
        ScreenController.showLogin();
    }
}
