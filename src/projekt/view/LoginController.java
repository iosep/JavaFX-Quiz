package projekt.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import projekt.MainApplication;
import projekt.model.FileReader;

import java.util.List;


/**
 * enthält Regeln und Informationen des Spiels
 */
public class LoginController {

    private List<String> playerImages;
    private int playerImageNum;

    @FXML
    private ImageView playerImgView;

    @FXML
    private TextField playerNameTextField;

    @FXML
    private Button loginButton;

    @FXML
    void initialize() {
        assert playerImgView != null : "fx:id=\"playerImgView\" was not injected: check your FXML file 'LoginScreen.fxml'.";
        assert playerNameTextField != null : "fx:id=\"playerNameTextField\" was not injected: check your FXML file 'LoginScreen.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'LoginScreen.fxml'.";

        playerImages = FileReader.getFileList("src/" + MainApplication.PATH_PLAYER_IMAGES);
        playerImageNum = -1;
        nextImageHandler(null);
    }

    @FXML
    void loginHandler(ActionEvent event) {
        System.out.println(event.getEventType().toString());
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

