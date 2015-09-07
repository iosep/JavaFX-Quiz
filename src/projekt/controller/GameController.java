package projekt.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import projekt.MainApplication;
import projekt.io.QuestionFileIO;
import projekt.model.Game;
import projekt.model.Player;
import projekt.model.Question;
import projekt.model.QuestionCatalog;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller für das Spiel.
 */
public class GameController implements Initializable {

    private final Game game;
    private boolean isAnswerChoosen;

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

    private List<Button> answerButtons;

    /**
     * Konstruktor des GameControllers.
     * Wird vor der Methode initialize aufgerufen.
     */
    public GameController() {
        game = new Game();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert playerNameText != null : "fx:id=\"playerNameText\" was not injected: check your FXML file 'Game.fxml'.";
        assert scoreLabel != null : "fx:id=\"scoreLabel\" was not injected: check your FXML file 'Game.fxml'.";
        assert playerImgView != null : "fx:id=\"playerImgView\" was not injected: check your FXML file 'Game.fxml'.";
        assert answerBButton != null : "fx:id=\"answerBButton\" was not injected: check your FXML file 'Game.fxml'.";
        assert answerDButton != null : "fx:id=\"answerDButton\" was not injected: check your FXML file 'Game.fxml'.";
        assert categoryLabel != null : "fx:id=\"categoryLabel\" was not injected: check your FXML file 'Game.fxml'.";
        assert answerAButton != null : "fx:id=\"answerAButton\" was not injected: check your FXML file 'Game.fxml'.";
        assert questionLabel != null : "fx:id=\"questionLabel\" was not injected: check your FXML file 'Game.fxml'.";
        assert answerCButton != null : "fx:id=\"answerCButton\" was not injected: check your FXML file 'Game.fxml'.";

        isAnswerChoosen = false;
        answerButtons = new ArrayList<>();
        answerButtons.add(answerAButton);
        answerButtons.add(answerBButton);
        answerButtons.add(answerCButton);
        answerButtons.add(answerDButton);

        try {
            // fragen einlesen
            QuestionCatalog questionCatalog = QuestionFileIO.parseQuestions();
            List<String> categories = questionCatalog.getCategories();

            // prüfen, ob genug fragen vorhanden sind
            if (categories.size() >= MainApplication.NUM_ROUNDS) {
                game.setCategories(categories);
                game.setQuestionCatalog(questionCatalog);

            } else {
                ScreenController.showWarningNotification("Not enough questions found!");
                ScreenController.showLogin();
            }

        } catch (IOException e) {
            ScreenController.showErrorNotification(e.getMessage());
        }
    }

    /**
     * Wählt eine Antwort aus.
     * Dazu wird der Text der Quelle des ActionEvents auf seine Richtigkeit überprüft.
     * Wenn das Spiel zuende ist, wird die highscore.txt-View angezeigt.
     *
     * @param event ActionEvent vom entsprechenden Anwort-Button
     */
    @FXML
    void chooseAnswerHandler(ActionEvent event) {
        if (!game.isFinished() && !isAnswerChoosen) {
            Question question = game.getCurrentQuestion();

            boolean isRight = game.chooseAnswer(((Button) event.getSource()).getText());
            isAnswerChoosen = true;

            // färbt die richtige Antwort grün
            for (Button answerButton : answerButtons) {
                if (question.isAnswerCorrect(answerButton.getText()))
                    answerButton.setStyle("-fx-background-color:#7fff00");
            }

            // färbt den antwortbutton rot, wenn die antwort falsch ist
            if (!isRight)
                ((Button) event.getSource()).setStyle("-fx-background-color:#dc143c");

            // setzt das spiel nach 2 sekunden fort
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(2000),
                    e -> {
                        // setzt button style zurück
                        for (Button answerButton : answerButtons) {
                            answerButton.setStyle("");
                        }
                        isAnswerChoosen = false;
                        display();

                        if (game.isFinished()) {
                            disableAnswerButtons(true);
                            ScreenController.showHighscore(game.getPlayer());
                        }
                    }));
            timeline.play();
        }

    }

    private void disableAnswerButtons(boolean value) {
        for (Button answerButton : answerButtons) {
            answerButton.setDisable(value);
        }
    }

    private void display() {
        // zeige punktestand
        scoreLabel.setText(String.valueOf(game.getPlayer().getScore()));

        // zeige kategorie und frage
        categoryLabel.setText(game.getCurrentCategory());
        questionLabel.setText(game.getCurrentQuestion().getQUESTION());

        // zeige antworten (zufällig)
        Collections.shuffle(answerButtons);
        for (int i = 0; i < game.getCurrentQuestion().getAnswers().size(); i++) {
            answerButtons.get(i).setText(game.getCurrentQuestion().getAnswers().get(i));
        }
    }

    /**
     * Initialisiert das Spiel und die View mit den Daten des Spielers.
     *
     * @param player Spieler, der das Spiel antritt.
     */
    public void initPlayer(Player player) {
        game.setPlayer(player);
        playerImgView.setImage(player.getImg());
        playerNameText.setText(player.getName());
        scoreLabel.setText(String.valueOf(player.getScore()));
        display();
    }
}
