package projekt.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import projekt.MainApplication;
import projekt.controller.ScreenController;
import projekt.model.FileReader;
import projekt.model.Player;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


/**
 * enthält Regeln und Informationen des Spiels
 */
public class LoginController implements Initializable {

    private List<String> playerImages;
    private int playerImageNum;

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

        playerImages = FileReader.getFileList("src/" + MainApplication.PATH_PLAYER_IMAGES);
        playerImageNum = 7;
        nextImageHandler(null);
    }

    @FXML
    void loginHandler(ActionEvent event) {
        if (playerNameTextField.getText().isEmpty()) {
            ScreenController.showWarningNotification("Please select a username", 1500);
        } else {
            try {
                ScreenController.showFindGameView(new Player(playerImgView.getImage(), playerNameTextField.getText()));
            } catch (IOException e) {
                ScreenController.showErrorNotification(e.getMessage(), 0);
            }
        }
    }


    @FXML
    void prevImageHandler(ActionEvent event) {
        playerImageNum = (playerImages.size() + --playerImageNum) % playerImages.size();
        playerImgView.setImage(new Image(MainApplication.PATH_PLAYER_IMAGES + playerImages.get(playerImageNum)));
    }

    @FXML
    void nextImageHandler(ActionEvent event) {
        playerImageNum = ++playerImageNum % playerImages.size();
        playerImgView.setImage(new Image(MainApplication.PATH_PLAYER_IMAGES + playerImages.get(playerImageNum)));
    }
}

