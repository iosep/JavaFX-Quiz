package projekt.model;

import projekt.MainApplication;
import projekt.controller.ScreenController;

import java.util.List;
import java.util.Random;

/**
 * enthält Informationen über die Funktionsweise des Spiels.
 * - Spieler sind abwechselnd an der Reihe
 * - pro Spiel gibt es 6 Runden, in jeder Runde werden 3 Fragen zu einer vorher ausgewählten Kategorie gestellt
 * - jeder Spielzug enthält ein festgelegtes Zeitlimit
 * - Spieler können verschiedene Joker nutzen: 50:50-Joker, Zeitverlängerungs-Joker, neue-Frage-Joker
 * - Bedingungen für Joker festlegen
 * - für jeden Spieler soll ein Highscore/Punktestand angezeigt werden
 * <p>
 * Created by Scratcherz on 28.07.2015.
 */
public class Game {
    private String currentCategory;
    private int roundNum;
    private int questionNum;
    private Question currentQuestion;
    private QuestionCatalog questionCatalog;
    private List<String> categories;
    private Player player;
    private Random rand;

    public Game() {
        questionNum = 0;
        roundNum = 0;
    }

    public String getCurrentCategory() {
        return currentCategory;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setQuestionCatalog(QuestionCatalog questionCatalog) {
        this.questionCatalog = questionCatalog;
        rand = new Random();
        currentCategory = categories.remove(rand.nextInt(categories.size()));
        currentQuestion = questionCatalog.getRandomQuestion(currentCategory);
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Wählt eine Antwort aus und gibt zurück, ob sie richtig ist oder nicht.
     *
     * @param answer Ausgewählte Antwort als String.
     * @return True, wenn Antwort richtig. False, wenn nicht.
     */
    public boolean chooseAnswer(String answer) {
        int score = player.getScore();
        questionNum++;

        if (currentQuestion.isAnswerCorrect(answer)) {
            player.setScore(score + MainApplication.RIGHT_ANSWER_SCORE);
            updateQuestion();
            return true;
        } else {
            player.setScore(score - MainApplication.WRONG_ANSWER_SCORE);
            updateQuestion();
            return false;
        }

    }

    private void updateQuestion() {
        questionNum++;

        if (questionNum % MainApplication.NUM_QUESTIONS_PER_ROUND == 0) {
            roundNum++;
            if (roundNum >= MainApplication.NUM_ROUNDS) {
                //ENDE
                ScreenController.showInformationNotification("---ENDE---\nScore: " + player.getScore(), 0);
            } else {
                // NEUE RUNDE
                currentCategory = categories.remove(rand.nextInt(categories.size()));
                currentQuestion = questionCatalog.getRandomQuestion(currentCategory);
            }
        } else {
            currentQuestion = questionCatalog.getRandomQuestion(currentCategory);
            // NÄCHSTE FRAGE
        }
    }
}
