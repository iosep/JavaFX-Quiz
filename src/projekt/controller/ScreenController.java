package projekt.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.controlsfx.control.NotificationPane;
import projekt.MainApplication;
import projekt.model.Player;
import projekt.view.FindGameController;

import java.io.IOException;

public class ScreenController {

    private static NotificationPane np;
    private static Stage primaryStage;

    public static void setPrimaryStage(Stage primaryStage) {
        primaryStage.setTitle("Scratchers");
        ScreenController.primaryStage = primaryStage;
    }

    public static void showNotification(String message) {
        np.setText(message);
        np.show();
    }

    public static void showLoginView() throws IOException {
        Pane login = FXMLLoader.load(MainApplication.class.getResource("view/LoginScreen.fxml"));

        // add notification pane for notification
        // source: http://controlsfx.bitbucket.org/org/controlsfx/control/NotificationPane.html
        np = new NotificationPane(login);
        Tab tab1 = new Tab("Tab 1");
        tab1.setContent(np);
        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(tab1);

        primaryStage.setScene(new Scene(login));
        primaryStage.show();
    }

    public static void showFindGameView(Player player) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("view/FindGame.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
        FindGameController findGameController = loader.<FindGameController>getController();
        findGameController.initPlayer(player);
        primaryStage.show();
    }

}
