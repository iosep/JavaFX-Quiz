package projekt;

import javafx.application.Application;
import javafx.stage.Stage;
import projekt.controller.ScreenController;

/**
 * MainApplication-Klasse. Enthält globale Parameter für das Spiel und dient als Start für die Applikation.
 */
public class MainApplication extends Application {
    public static final String TITLE = "JavaFx Quiz";
    public static final String DIR_PLAYER_IMAGES = "projekt/data/img/player/";
    public static final String PATH_HIGHSCORE = "src/projekt/data/highscore.txt";
    public static final String PATH_QUESTIONS = "src/projekt/data/questions.txt";

    // Anzahl an Fragerunden
    public static final int NUM_ROUNDS = 5;

    // Anzahl an Fragen pro Runde
    public static final int NUM_QUESTIONS_PER_ROUND = 3;

    // Antwortmöglichkeiten pro Frage (für Fehler, bei ungültiger fragen-Datei)
    public static final int NUM_QUESTION_POSSIBILITIES = 4;

    // Punkte für eine richtige Antwort
    public static final int RIGHT_ANSWER_SCORE = 100;

    // Punkte für eine falsche Antwort
    public static final int WRONG_ANSWER_SCORE = -50;

    // Anzahl an Highscoreplätzen
    public static final int MAX_HIGHSCORE_SLOTS = 10;

    @Override
    public void start(Stage primaryStage) throws Exception {
        ScreenController.setPrimaryStage(primaryStage);
        ScreenController.showLogin();
    }
}
