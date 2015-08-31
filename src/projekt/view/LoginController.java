package projekt.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import projekt.controller.ScreenController;
import projekt.model.Player;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;


/**
 * enthält Regeln und Informationen des Spiels
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

        player = new Player(new Random().nextInt(Player.getSizeOfPlayerImages()), "");
        playerImgView.setImage(playerImgView.getImage());
    }

    @FXML
    void nextImageHandler(ActionEvent event) {
        player.setImageNum((player.getImageNum() + 1) % Player.getSizeOfPlayerImages());
        playerImgView.setImage(player.getImg());
    }

    @FXML
    void loginHandler(ActionEvent event) {
        if (playerNameTextField.getText().isEmpty()) {
            ScreenController.showWarningNotification("Please select a username", 1500);
        } else {
            player.setScore(0);

            ScreenController.showGameView(player);
//                ScreenController.showFindGameView(new Player(playerImgView.getImage(), playerNameTextField.getText()));
        }
    }

    @FXML
    void prevImageHandler(ActionEvent event) {
        player.setImageNum((Player.getSizeOfPlayerImages() + player.getImageNum() - 1) % Player.getSizeOfPlayerImages());
        playerImgView.setImage(player.getImg());
    }
}

