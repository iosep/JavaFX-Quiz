package projekt.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import projekt.controller.ScreenController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    void newGameHandler() throws IOException {
        ScreenController.showLoginView();
    }

    @FXML
    void saveGameHandler() {
        System.out.println("Spiel speichern");
    }

    @FXML
    void quitGameHandler() {
        System.exit(0);
    }

    @FXML
    void showRulesHandler() throws IOException {
        ScreenController.showRules();
    }

    @FXML
    void aboutUsHandler() throws IOException {
        ScreenController.showAboutUs();
    }
}
