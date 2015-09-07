package projekt.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import projekt.MainApplication;
import projekt.io.HighscoreFileIO;
import projekt.model.Player;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller für die Highscores.
 */
public class HighscoreController implements Initializable {

    @FXML
    private Text playerNameText;

    @FXML
    private ImageView playerImgView;

    @FXML
    private Text playerScoreText;

    private Player player;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert playerNameText != null : "fx:id=\"playerNameText\" was not injected: check your FXML file 'Highscore.fxml'.";
        assert playerImgView != null : "fx:id=\"playerImgView\" was not injected: check your FXML file 'Highscore.fxml'.";
        assert playerScoreText != null : "fx:id=\"playerScoreText\" was not injected: check your FXML file 'Highscore.fxml'.";
    }

    /**
     * Initialisiert die View mit den Daten des Spielers.
     *
     * @param player Spieler, der das Spiel gewonnen hat.
     */
    public void initPlayer(Player player) {
        this.player = player;
        playerImgView.setImage(player.getImg());
        playerNameText.setText(player.getName());
        playerScoreText.setText(String.valueOf(player.getScore()));
    }

    /**
     * Initialisiert die View mit den Highscore-Daten.
     *
     * @param root Container, dem die Einträge hinzugefügt werden sollen.
     */
    public void initHighscore(Parent root) {
        try {
            LinkedList<Player> players = HighscoreFileIO.parseScores();

            boolean added = false;
            for (int i = 0; i < players.size(); i++) {
                Player player = players.get(i);
                if (this.player.getScore() > player.getScore()) {
                    players.add(i, this.player);
                    added = true;
                    break;
                }
            }

            if (!added && players.size() < MainApplication.MAX_HIGHSCORE_SLOTS) {
                players.add(player);
            }

            HighscoreFileIO.writeScores(players);

            displayHighscore((Pane) root, players);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayHighscore(Pane root, List<Player> players) {
        HBox scoreEntry;
        ImageView playerImg;
        Text playerName;
        Text playerScore;
        int i = 0;
        while (i < MainApplication.MAX_HIGHSCORE_SLOTS && i < players.size()) {
            Player player = players.get(i);

            // erzeugt eine neue hbox
            scoreEntry = new HBox();
            scoreEntry.setAlignment(Pos.TOP_CENTER);
            scoreEntry.setSpacing(10);

            // fügt ein bild zum eintrag hinzu
            playerImg = new ImageView(player.getImg());
            playerImg.setFitWidth(25);
            playerImg.setFitHeight(25);
            scoreEntry.getChildren().add(playerImg);

            // fügt den spielernamen zum Eintrag hinzu
            playerName = new Text(player.getName());
            playerName.setTextAlignment(TextAlignment.LEFT);
            scoreEntry.getChildren().add(playerName);

            // fügt die punktzahl zum Eintrag hinzu
            playerScore = new Text(String.valueOf(player.getScore()));
            playerScore.setTextAlignment(TextAlignment.RIGHT);
            scoreEntry.getChildren().add(playerScore);

            // fügt den eintrag in der highscoreliste hinzu
            root.getChildren().add(scoreEntry);

            i++;
        }
    }
}
