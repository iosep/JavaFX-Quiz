package projekt.model;

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
    String currentCategory;
    Question currentQuestion;
    private QuestionCatalog questionCatalog;
    private List<String> categories;
    private Player player;
    private Random rand;

    public Game() {
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

    public void setPlayer(Player player) {
        this.player = player;
    }
}
