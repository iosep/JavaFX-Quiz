package projekt.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import projekt.MainApplication;
import projekt.controller.ScreenController;
import projekt.model.Game;
import projekt.model.Player;
import projekt.model.QuestionCatalog;
import projekt.model.QuestionFileReader;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * enthält Regeln und Informationen des Spiels
 */
public class Game2Controller implements Initializable {

    Game game;

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

    private Button[] answerButtons;

    /**
     * Constructor of game controller class.
     * Is called before initialize() method.
     */
    public Game2Controller() {
        game = new Game();
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

        answerButtons = new Button[]{answerAButton, answerBButton, answerCButton, answerDButton};

        try {
            // fragen einlesen
            QuestionCatalog questionCatalog = QuestionFileReader.parseQuestions("src/projekt/data/questions.txt");
            List<String> categories = questionCatalog.getCategories(MainApplication.NUM_QUESTIONS_PER_ROUND);

            // prüfen, ob genug fragen vorhanden sind
            if (categories.size() >= MainApplication.NUM_ROUNDS) {
                game.setCategories(categories);
                game.setQuestionCatalog(questionCatalog);

            } else {
                ScreenController.showWarningNotification("Not enough questions found!", 0);
                ScreenController.showFinalScreen(null);
            }

        } catch (IOException e) {
            ScreenController.showErrorNotification(e.getMessage(), 0);
        }
    }

    @FXML
    void chooseAnswerA() {
        game.chooseAnswer(answerAButton.getText());
        display();
    }

    private void display() {
        // zeige punktestand
        scoreLabel.setText(String.valueOf(game.getPlayer().getScore()));

        // zeige kategorie und frage
        categoryLabel.setText(game.getCurrentCategory());
        questionLabel.setText(game.getCurrentQuestion().getQUESTION());

        // zeige antworten
        for (int i = 0; i < game.getCurrentQuestion().getAnswers().size(); i++) {
            // TODO: Antworten zufällig zeigen -> Später auf Vergleich achten
            answerButtons[i].setText(game.getCurrentQuestion().getAnswers().get(i));
        }
    }

    @FXML
    void chooseAnswerB() {
        game.chooseAnswer(answerBButton.getText());
        display();
    }

    @FXML
    void chooseAnswerC() {
        game.chooseAnswer(answerCButton.getText());
        display();
    }

    @FXML
    void chooseAnswerD() {
        game.chooseAnswer(answerDButton.getText());
        display();
    }

    public void initPlayer(Player player) {
        game.setPlayer(player);
        playerImgView.setImage(player.getImg());
        playerNameText.setText(player.getName());
        scoreLabel.setText(String.valueOf(player.getScore()));
        display();
    }
}
