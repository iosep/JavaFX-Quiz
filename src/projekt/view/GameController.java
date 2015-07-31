package projekt.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import projekt.Start;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * enthält Regeln und Informationen des Spiels
 */
public class GameController implements Initializable {

    @FXML
    private Circle jokerOneRight;

    @FXML
    private Circle jokerThreeLeft;

    @FXML
    private Label playerOneLabel;

    @FXML
    private Label categoryLabel;

    @FXML
    private Button answerALabel;

    @FXML
    private Button answerBLabel;

    @FXML
    private Button answerCLabel;

    @FXML
    private Button answerDLabel;

    @FXML
    private Circle jokerTwoLeft;

    @FXML
    private Circle playerTwoImg;

    @FXML
    private Label questionLabel;

    @FXML
    private Label scoreLabel;

    @FXML
    private Label playerTwoLabel;

    @FXML
    private Circle jokerThreeRight;

    @FXML
    private Circle playerOneImg;

    @FXML
    private Circle jokerOne;

    @FXML
    private Circle jokerTwoRight;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert jokerOneRight != null : "fx:id=\"jokerOneRight\" was not injected: check your FXML file 'Game.fxml'.";
        assert jokerThreeLeft != null : "fx:id=\"jokerThreeLeft\" was not injected: check your FXML file 'Game.fxml'.";
        assert playerOneLabel != null : "fx:id=\"playerOneLabel\" was not injected: check your FXML file 'Game.fxml'.";
        assert categoryLabel != null : "fx:id=\"categoryLabel\" was not injected: check your FXML file 'Game.fxml'.";
        assert answerBLabel != null : "fx:id=\"answerBLabel\" was not injected: check your FXML file 'Game.fxml'.";
        assert answerDLabel != null : "fx:id=\"answerDLabel\" was not injected: check your FXML file 'Game.fxml'.";
        assert jokerTwoLeft != null : "fx:id=\"jokerTwoLeft\" was not injected: check your FXML file 'Game.fxml'.";
        assert playerTwoImg != null : "fx:id=\"playerTwoImg\" was not injected: check your FXML file 'Game.fxml'.";
        assert questionLabel != null : "fx:id=\"questionLabel\" was not injected: check your FXML file 'Game.fxml'.";
        assert scoreLabel != null : "fx:id=\"scoreLabel\" was not injected: check your FXML file 'Game.fxml'.";
        assert playerTwoLabel != null : "fx:id=\"playerTwoLabel\" was not injected: check your FXML file 'Game.fxml'.";
        assert jokerThreeRight != null : "fx:id=\"jokerThreeRight\" was not injected: check your FXML file 'Game.fxml'.";
        assert answerALabel != null : "fx:id=\"answerALabel\" was not injected: check your FXML file 'Game.fxml'.";
        assert playerOneImg != null : "fx:id=\"playerOneImg\" was not injected: check your FXML file 'Game.fxml'.";
        assert jokerOne != null : "fx:id=\"jokerOne\" was not injected: check your FXML file 'Game.fxml'.";
        assert jokerTwoRight != null : "fx:id=\"jokerTwoRight\" was not injected: check your FXML file 'Game.fxml'.";
        assert answerCLabel != null : "fx:id=\"answerCLabel\" was not injected: check your FXML file 'Game.fxml'.";
    }

    @FXML
    void onMouseClicked() {
        System.out.println("Dies ist ein Test");
    }

    // Reference to the main app
    private Start mainApp;

    /**
     * Constructor of game controller class.
     * Is called before initialize() method.
     */
    public GameController() {

    }

}
