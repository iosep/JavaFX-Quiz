package projekt.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import projekt.MainApplication;
import projekt.model.HighscoreFileReader;
import projekt.model.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HighscoreController implements Initializable {

    @FXML
    private Text playerNameText;

    @FXML
    private ImageView playerImgView;

    @FXML
    private Text playerScoreText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert playerNameText != null : "fx:id=\"playerNameText\" was not injected: check your FXML file 'highscore.txt.fxml'.";
        assert playerImgView != null : "fx:id=\"playerImgView\" was not injected: check your FXML file 'highscore.txt.fxml'.";
        assert playerScoreText != null : "fx:id=\"playerScoreText\" was not injected: check your FXML file 'highscore.txt.fxml'.";

        try {
            HighscoreFileReader.parseScores(MainApplication.PATH_HIGHSCORE);
        } catch (IOException e) {
            ScreenController.showErrorNotification(e.getMessage(), 0);
        }
    }

    /**
     * Initialisiert die View mit den Daten des Spielers.
     *
     * @param player Spieler, der das Spiel gewonnen hat.
     */
    public void initPlayer(Player player) {
        playerImgView.setImage(player.getImg());
        playerNameText.setText(player.getName());
        playerScoreText.setText(String.valueOf(player.getScore()));
        System.out.println("inti");
    }
}
