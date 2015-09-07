package projekt.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
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
     *
     * @throws IOException wenn entsprechende fxml-Datei nicht geladen werden kann.
     */
    @FXML
    void newGameHandler() throws IOException {
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
     *
     * @throws IOException wenn entsprechende fxml-Datei nicht geladen werden kann.
     */
    @FXML
    void showRulesHandler() throws IOException {
        ScreenController.showRules();
    }

    /**
     * Zeigt das Fenster "Über uns" an.
     *
     * @throws IOException wenn entsprechende fxml-Datei nicht geladen werden kann.
     */
    @FXML
    void aboutUsHandler() throws IOException {
        ScreenController.showAboutUs();
    }
}
