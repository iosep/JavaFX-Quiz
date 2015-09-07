package projekt.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.controlsfx.control.NotificationPane;
import projekt.MainApplication;
import projekt.model.Player;

import java.io.IOException;

/**
 * Controller zum Verwalten der Fenster.
 */
public class ScreenController {

    private static NotificationPane notificationPane;
    private static Stage primaryStage;
    private static Stage secondaryStage;
    private static BorderPane root;

    public static void setPrimaryStage(Stage primaryStage) throws IOException {
        primaryStage.setTitle(MainApplication.TITLE);
        root = FXMLLoader.load(MainApplication.class.getResource("view/Root.fxml"));
        primaryStage.setScene(new Scene(root));
        ScreenController.primaryStage = primaryStage;
    }

    /**
     * Zeigt dem Benutzer eine Fehlermeldung an.
     *
     * @param message Anzuzeigende Nachricht.
     */
    public static void showErrorNotification(String message) {
        showNotification("ERROR: " + message);
    }

    /**
     * Zeigt dem Benutzer eine Warnung an.
     *
     * @param message Anzuzeigende Nachricht.
     */
    public static void showWarningNotification(String message) {
        showNotification("WARNING: " + message);
    }

    /**
     * Zeigt dem Benutzer eine Information an.
     *
     * @param message Anzuzeigende Nachricht.
     */
    public static void showInformationNotification(String message) {
        showNotification("Information: " + message);
    }

    private static void showNotification(String text) {
        System.out.println(text);
    }

    /**
     * Lädt eine fxml Datei mithilfe des FXMLLoaders und bettet sie in das Root-layout ein.
     *
     * @param fxml Dateiname der zu ladenden fxml-Datei, ohne ".fxml"-Suffix.
     * @param <T>  Controllerklasse.
     * @return Controller der fxml-Datei.
     */
    private static <T> T loadSceneToPrimaryStage(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("view/" + fxml + ".fxml"));

        try {
            root = FXMLLoader.load(MainApplication.class.getResource("view/Root.fxml"));
            root.setCenter(fxmlLoader.load());
            primaryStage.setScene(new Scene(root));
        } catch (IOException e) {
            showErrorNotification("FXML-Datei konnte nicht geladen werden (" + fxml + ".fxml)");
        }

        primaryStage.show();
        return fxmlLoader.<T>getController();
    }

    /**
     * Lädt eine fxml Datei mithilfe des FXMLLoaders und zeigt sie in einem zweiten Fenster an.
     *
     * @param fxml Dateiname der zu ladenden fxml-Datei, ohne ".fxml"-Suffix.
     * @param <T>  Controllerklasse.
     * @return Controller der fxml-Datei.
     */
    private static <T> T loadSceneToSecondaryStage(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("view/" + fxml + ".fxml"));

        if (secondaryStage == null) {
            secondaryStage = new Stage();
        }
        try {
            secondaryStage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException e) {
            showErrorNotification("FXML-Datei konnte nicht geladen werden (" + e.getMessage() + ")");
        }

        secondaryStage.show();
        return fxmlLoader.<T>getController();
    }

    /**
     * Lädt die Login-View in das Hauptfenster.
     */
    public static void showLogin() {
        loadSceneToPrimaryStage("LoginScreen");
    }

    /**
     * Zeigt das Fenster "Spielregeln" an.
     */
    public static void showRules() {
        loadSceneToSecondaryStage("Rules");
        secondaryStage.show();
    }

    /**
     * Zeigt das Fenster "Über uns" an.
     */
    public static void showAboutUs() {
        loadSceneToSecondaryStage("AboutUs");
    }

    /**
     * Lädt die Spiel-View in das Hauptfenster.
     */
    public static void showGame(Player player) {
        GameController gameController = loadSceneToPrimaryStage("Game");
        gameController.initPlayer(player);
    }

    /**
     * Zeigt die Highscores in einem zweiten Fenster an.
     */
    public static void showHighscore(Player player) {
        HighscoreController highscoreController = loadSceneToSecondaryStage("Highscore");
        highscoreController.initPlayer(player);
        highscoreController.initHighscore(secondaryStage.getScene().getRoot());
    }
}
