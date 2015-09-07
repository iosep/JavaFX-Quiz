package projekt.model;

import projekt.MainApplication;

import java.util.List;
import java.util.Random;

/**
 * Klasse zum Erstellen eines Spiels.
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
    private boolean finished;

    /**
     * Erstellt ein neues Spiel.
     */
    public Game() {
        questionNum = 0;
        roundNum = 0;
        finished = false;
    }

    /**
     * Gibt die aktuelle Kategorie zurück.
     *
     * @return Aktuelle Kategorie als String.
     */
    public String getCurrentCategory() {
        return currentCategory;
    }

    /**
     * Gibt die aktuelle Frage zurück.
     *
     * @return Aktuelle Frage als Question-Objekt zurück.
     */
    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    /**
     * Setzt einen Fragekatalog.
     *
     * @param questionCatalog QuestionCatalog für dieses Spiel.
     */
    public void setQuestionCatalog(QuestionCatalog questionCatalog) {
        this.questionCatalog = questionCatalog;
        rand = new Random();
        currentCategory = categories.remove(rand.nextInt(categories.size()));
        currentQuestion = questionCatalog.getRandomQuestion(currentCategory);
    }

    /**
     * Setzt eine Liste mit möglichen Kategorien für dieses Spiel.
     *
     * @param categories Liste mit Kategorien als String.
     */
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    /**
     * Gibt den Spieler zurück, der dieses Spiel spielt.
     *
     * @return Player-Object des aktuellen Spielers.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Setzt einen Spieler für dieses Spiel.
     *
     * @param player Player-Object, der das Spiel spielen soll.
     */
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
            updateStatus();
            return true;
        } else {
            player.setScore(score + MainApplication.WRONG_ANSWER_SCORE);
            updateStatus();
            return false;
        }

    }

    /**
     * Lädt die nächste Frage und Kategorie bzw. beendet das Spiel.
     * Die Parameter dazu werden in der MainApplication Klasse gesetzt.
     */
    private void updateStatus() {
        questionNum++;

        if (questionNum % MainApplication.NUM_QUESTIONS_PER_ROUND == 0) {
            roundNum++;
            if (roundNum >= MainApplication.NUM_ROUNDS) {
                //ENDE
                this.finished = true;
            } else {
                // NEUE RUNDE
                currentCategory = categories.remove(rand.nextInt(categories.size()));
                currentQuestion = questionCatalog.getRandomQuestion(currentCategory);
            }
        } else {
            // NÄCHSTE FRAGE
            currentQuestion = questionCatalog.getRandomQuestion(currentCategory);
        }
    }

    /**
     * Gibt zurück, ob das Spiel beendet ist oder nicht.
     *
     * @return True, falls das Spiel beendet ist, false, falls nicht.
     */
    public boolean isFinished() {
        return finished;
    }
}
