package projekt.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.controlsfx.control.NotificationPane;
import projekt.MainApplication;
import projekt.model.Player;

import java.io.IOException;

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
     * Shows an error to the user.
     *
     * @param message  Warning message.
     * @param duration Duration in ms. If 0 it is set to indefinitely.
     */
    public static void showErrorNotification(String message, double duration) {
        showNotification(duration, "ERROR: " + message);
    }

    /**
     * Shows a warning to the user.
     *
     * @param message  Warning message.
     * @param duration Duration in ms. If 0 it is set to indefinitely.
     */
    public static void showWarningNotification(String message, double duration) {
        showNotification(duration, "WARNING: " + message);
    }

    /**
     * Shows an information to the user.
     *
     * @param message  Warning message.
     * @param duration Duration in ms. If 0 it is set to indefinitely.
     */
    public static void showInformationNotification(String message, double duration) {
        showNotification(duration, "Information: " + message);
    }

    private static void showNotification(double duration, String text) {
        System.out.println(text);
/*
        if (duration > 0) {
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(duration),
                    ae -> notificationPane.hide()));
            timeline.play();
        }
        notificationPane.show(text);
*/
    }

    /**
     * Loads an fxml file via the FXMLLoader and wraps the layout in a notification pane to be able to show notifications.
     *
     * @param fxml File name of the fxml file without ".fmlx" suffix.
     * @param <T>  Type of controller
     * @return Controller of the fxml file.
     */
    private static <T> T loadSceneToPrimaryStage(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("view/" + fxml + ".fxml"));
        // Wrap layout in notification pane to be able to show notifications
        // source: http://controlsfx.bitbucket.org/org/controlsfx/control/NotificationPane.html
//        notificationPane = new NotificationPane(fxmlLoader.load());
//        primaryStage.setScene(new Scene(notificationPane));
        try {
            root = FXMLLoader.load(MainApplication.class.getResource("view/Root.fxml"));
            root.setCenter(fxmlLoader.load());
            primaryStage.setScene(new Scene(root));
        } catch (IOException e) {
            showErrorNotification("FXML-Datei konnte nicht geladen werden (" + fxml + ".fxml)", 0);
        }

        primaryStage.show();
        return fxmlLoader.<T>getController();
    }

    /**
     * Loads an fxml file via the FXMLLoader and wraps the layout in a notification pane to be able to show notifications.
     *
     * @param fxml File name of the fxml file without ".fmlx" suffix.
     * @param <T>  Type of controller
     * @return Controller of the fxml file.
     */
    private static <T> T loadSceneToSecondaryStage(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("view/" + fxml + ".fxml"));

        if (secondaryStage == null) {
            secondaryStage = new Stage();
        }
        try {
            secondaryStage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException e) {
            showErrorNotification("FXML-Datei konnte nicht geladen werden (" + e.getMessage() + ")", 0);
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
     * Lädt die FindGame-View in das Hauptfenster.
     */
    public static void showFindGame(Player player) {
        FindGameController findGameController = loadSceneToPrimaryStage("FindGame");
        findGameController.initPlayer(player);
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
        Game2Controller gameController = loadSceneToPrimaryStage("Game2");
        gameController.initPlayer(player);
    }

    /**
     * Lädt die highscore.txt-View in das Hauptfenster.
     */
    public static void showHighscore(Player player) {
        HighscoreController highscoreController = loadSceneToSecondaryStage("Highscore");
        highscoreController.initPlayer(player);
        highscoreController.initHighscore(secondaryStage.getScene().getRoot());
    }
}
