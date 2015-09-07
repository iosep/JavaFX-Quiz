package projekt.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller für die Menüleiste.
 */
public class RootController implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * Startet ein neues Spiel.
     */
    @FXML
    void newGameHandler() {
        ScreenController.showLogin();
    }

    /**
     * Speichert ein Spiel.
     */
    @FXML
    void saveGameHandler() {
        System.out.println("Spiel speichern... Speicherfunktion noch nicht vorhanden.");
    }

    /**
     * Beendet ein Spiel.
     */
    @FXML
    void quitGameHandler() {
        System.exit(0);
    }

    /**
     * Zeigt die Regeln für das Spiel an.
     */
    @FXML
    void showRulesHandler() {
        ScreenController.showRules();
    }

    /**
     * Zeigt das Fenster "Über uns" an.
     */
    @FXML
    void aboutUsHandler() {
        ScreenController.showAboutUs();
    }
}
