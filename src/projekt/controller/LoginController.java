package projekt.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import projekt.model.Player;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;


/**
 * Controller für den Login.
 */
public class LoginController implements Initializable {

    private Player player;

    @FXML
    private ImageView playerImgView;

    @FXML
    private TextField playerNameTextField;

    @FXML
    private Button loginButton;

    public LoginController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert playerImgView != null : "fx:id=\"playerImgView\" was not injected: check your FXML file 'LoginScreen.fxml'.";
        assert playerNameTextField != null : "fx:id=\"playerNameTextField\" was not injected: check your FXML file 'LoginScreen.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'LoginScreen.fxml'.";

        player = new Player(new Random().nextInt(Player.getSizeOfPlayerImages()));
        playerImgView.setImage(player.getImg());
    }

    /**
     * Schaltet auf das nächste Bild um.
     */
    @FXML
    void nextImageHandler() {
        player.setImageNum((player.getImageNum() + 1) % Player.getSizeOfPlayerImages());
        playerImgView.setImage(player.getImg());
    }

    /**
     * Schaltet auf das vorherige Bild um.
     */
    @FXML
    void prevImageHandler() {
        player.setImageNum((Player.getSizeOfPlayerImages() + player.getImageNum() - 1) % Player.getSizeOfPlayerImages());
        playerImgView.setImage(player.getImg());
    }

    /**
     * Erstellt das Spieler-Objekt und übergibt es an den ScreenController, um das Spiel zu starten.
     */
    @FXML
    void loginHandler() {
        if (playerNameTextField.getText().isEmpty()) {
            ScreenController.showWarningNotification("Please select a username");
        } else {
            player.setName(playerNameTextField.getText());
            player.setScore(0);

            ScreenController.showGame(player);
        }
    }
}

