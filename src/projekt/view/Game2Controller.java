package projekt.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import projekt.model.Player;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * enthält Regeln und Informationen des Spiels
 */
public class Game2Controller implements Initializable {

    @FXML
    private Label playerNameText;

    @FXML
    private Label scoreLabel;

    @FXML
    private ImageView playerImgView;

    @FXML
    private Button answerBButton;

    @FXML
    private Button answerDButton;

    @FXML
    private Label categoryLabel;

    @FXML
    private Button answerAButton;

    @FXML
    private Label questionLabel;

    @FXML
    private Button answerCButton;

    /**
     * Constructor of game controller class.
     * Is called before initialize() method.
     */
    public Game2Controller() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert playerNameText != null : "fx:id=\"playerNameText\" was not injected: check your FXML file 'Game2.fxml'.";
        assert scoreLabel != null : "fx:id=\"scoreLabel\" was not injected: check your FXML file 'Game2.fxml'.";
        assert playerImgView != null : "fx:id=\"playerImgView\" was not injected: check your FXML file 'Game2.fxml'.";
        assert answerBButton != null : "fx:id=\"answerBButton\" was not injected: check your FXML file 'Game2.fxml'.";
        assert answerDButton != null : "fx:id=\"answerDButton\" was not injected: check your FXML file 'Game2.fxml'.";
        assert categoryLabel != null : "fx:id=\"categoryLabel\" was not injected: check your FXML file 'Game2.fxml'.";
        assert answerAButton != null : "fx:id=\"answerAButton\" was not injected: check your FXML file 'Game2.fxml'.";
        assert questionLabel != null : "fx:id=\"questionLabel\" was not injected: check your FXML file 'Game2.fxml'.";
        assert answerCButton != null : "fx:id=\"answerCButton\" was not injected: check your FXML file 'Game2.fxml'.";
    }

    public void initPlayer(Player player) {
        playerImgView.setImage(player.getImg());
        playerNameText.setText(player.getName());
        scoreLabel.setText(String.valueOf(player.getScore()));
    }
}
