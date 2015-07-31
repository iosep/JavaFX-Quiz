package projekt.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.NotificationPane;
import projekt.MainApplication;
import projekt.model.Player;
import projekt.view.FindGameController;

import java.io.IOException;

public class ScreenController {

    private static NotificationPane notificationPane;
    private static Stage primaryStage;

    public static void setPrimaryStage(Stage primaryStage) {
        primaryStage.setTitle(MainApplication.TITLE);
        ScreenController.primaryStage = primaryStage;
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

    /**
     * Shows an error to the user.
     *
     * @param message  Warning message.
     * @param duration Duration in ms. If 0 it is set to indefinitely.
     */
    public static void showErrorNotification(String message, double duration) {
        showNotification(duration, "ERROR: " + message);
    }

    private static void showNotification(double duration, String text) {
        if (duration > 0) {
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(duration),
                    ae -> notificationPane.hide()));
            timeline.play();
        }
        notificationPane.show(text);
    }

    public static void showLoginView() throws IOException {
        loadSceneToPrimaryStage("LoginScreen");
        primaryStage.show();
    }

    /**
     * Loads an fxml file via the FXMLLoader and wraps the layout in a notification pane to be able to show notifications.
     *
     * @param fxml File name of the fxml file without ".fmlx" suffix.
     * @param <T>  Type of controller
     * @return Controller of the fxml file.
     * @throws IOException if the fxml file can't be loaded
     */
    private static <T> T loadSceneToPrimaryStage(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("view/" + fxml + ".fxml"));

        // Wrap layout in notification pane to be able to show notifications
        // source: http://controlsfx.bitbucket.org/org/controlsfx/control/NotificationPane.html
        notificationPane = new NotificationPane(fxmlLoader.load());
        primaryStage.setScene(new Scene(notificationPane));
        return fxmlLoader.<T>getController();
    }

    public static void showFindGameView(Player player) throws IOException {
        FindGameController findGameController = loadSceneToPrimaryStage("FindGame");
        findGameController.initPlayer(player);
        primaryStage.show();
    }

}