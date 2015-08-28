package projekt.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.controlsfx.control.NotificationPane;
import projekt.MainApplication;
import projekt.model.Player;
import projekt.view.FindGameController;
import projekt.view.Game2Controller;

import java.io.IOException;

public class ScreenController {

    private static NotificationPane notificationPane;
    private static Stage primaryStage;
    private static Stage secondaryStage;

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
//        notificationPane = new NotificationPane(fxmlLoader.load());
//        primaryStage.setScene(new Scene(notificationPane));

        BorderPane root = FXMLLoader.load(MainApplication.class.getResource("view/Root.fxml"));
        root.setCenter(fxmlLoader.load());
        primaryStage.setScene(new Scene(root));
        return fxmlLoader.<T>getController();
    }

    public static void showFindGameView(Player player) throws IOException {
        FindGameController findGameController = loadSceneToPrimaryStage("FindGame");
        findGameController.initPlayer(player);
        primaryStage.show();
    }

    public static void showRules() throws IOException {
        loadSceneToSecondaryStage("Rules");
        secondaryStage.show();
    }

    /**
     * Loads an fxml file via the FXMLLoader and wraps the layout in a notification pane to be able to show notifications.
     *
     * @param fxml File name of the fxml file without ".fmlx" suffix.
     * @param <T>  Type of controller
     * @return Controller of the fxml file.
     * @throws IOException if the fxml file can't be loaded
     */
    private static <T> T loadSceneToSecondaryStage(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("view/" + fxml + ".fxml"));

        if (secondaryStage == null) {
            secondaryStage = new Stage();
        }
        secondaryStage.setScene(new Scene(fxmlLoader.load()));
        return fxmlLoader.<T>getController();
    }

    public static void showAboutUs() throws IOException {
        loadSceneToSecondaryStage("AboutUs");
        secondaryStage.show();
    }

    public static void showGameView(Player player) throws IOException {
        Game2Controller gameController = loadSceneToPrimaryStage("Game2");
        gameController.initPlayer(player);
        primaryStage.show();
    }
}
