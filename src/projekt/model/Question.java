package projekt.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse zum Erstellen von Question-Objekten.
 * Sie enthält die Frage, die Antwortmöglichkeiten als Array und die richtige Antwort als Index in dem Array.
 */
public class Question {

    private final String QUESTION;
    private final List<String> ANSWERS;
    private int correctAnswerIndex;

    /**
     * Konstruktor für Frageobjekt, das nur die Frage und eine leere Liste mit Antwortmöglichkeiten enthält.
     *
     * @param question String, der die Frage enthält.
     */
    public Question(String question) {
        if (question == null) {
            throw new IllegalArgumentException("Question parameter cannot be null.");
        }

        QUESTION = question;
        ANSWERS = new ArrayList<>(4);
        correctAnswerIndex = -1;
    }

    /**
     * Kontruktor für ein Frageobjekt.
     *
     * @param question           String, der die Frage enthält.
     * @param answers            Liste von Strings, die die Antwortmöglichkeiten enthalten.
     * @param correctAnswerIndex Index der Antwortliste, an der die richtige Antwort liegt.
     * @throws IllegalArgumentException wenn die Antwortliste oder die Frage null oder die Kombination der Parameter nicht valide ist.
     */
    public Question(String question, List<String> answers, int correctAnswerIndex) throws IllegalArgumentException {
        if (question == null || answers == null) {
            throw new IllegalArgumentException("Question or answer parameter cannot be null.");
        }

        this.QUESTION = question;
        this.ANSWERS = answers;
        this.correctAnswerIndex = correctAnswerIndex;

        if (!this.isValid()) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Überprüft das Question-Objekt auf seine Richtigkeit und gibt ein boolean zurück.
     *
     * @return True, wenn die Frage valide ist. False, wenn nicht.
     */
    public boolean isValid() {
        return !QUESTION.isEmpty() && ANSWERS.size() >= 2 && correctAnswerIndex > -1 && correctAnswerIndex < ANSWERS.size();
    }

    /**
     * Überprüft das Question-Objekt auf seine Richtigkeit und gibt ein boolean zurück.
     *
     * @param numPossibilities Gibt die Anzahl der Anwortmöglichkeiten an, die die Frage besitzen darf.
     * @return True, wenn die Frage valide ist. False, wenn nicht.
     */
    public boolean isValid(int numPossibilities) {
        return !QUESTION.isEmpty() && ANSWERS.size() >= 2 && ANSWERS.size() == 4 && correctAnswerIndex > -1 && correctAnswerIndex < ANSWERS.size();
    }

    public String getQUESTION() {
        return QUESTION;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(QUESTION);
        sb.append(" ");

        for (int i = 0; i < ANSWERS.size(); i++) {
            sb.append(ANSWERS.get(i));

            if (i == correctAnswerIndex) {
                sb.append(" (").append("\u2713").append(")");
            }

            if (i < ANSWERS.size() - 1) {
                sb.append("; ");
            }
        }

        return sb.toString();
    }

    /**
     * Fügt eine neue (falsche) Antwortmöglichkeit hinzu.
     *
     * @param answer String der die Antwortmöglichkeit enthält.
     */
    public void addAnswer(String answer) {
        ANSWERS.add(answer);
    }

    /**
     * Fügt eine neue (richtige) Antwortmöglichkeit hinzu.
     *
     * @param answer String der die richtige Antwort enthält.
     */
    public void addCorrectAnswer(String answer) {
        correctAnswerIndex = ANSWERS.size();
        ANSWERS.add(answer);
    }

    /**
     * Gibt die Antwortmöglichkeiten als Liste mit Strings zurück.
     *
     * @return Antwortmöglichkeiten
     */
    public List<String> getAnswers() {
        return ANSWERS;
    }

    /**
     * Überprüft, ob eine Antwort richtig ist.
     *
     * @param answer Zu prüfende Antwort..
     * @return True, wenn Antwort richtig ist. False, wenn nicht.
     */
    public boolean isAnswerCorrect(String answer) {
        return answer.equals(ANSWERS.get(correctAnswerIndex));
    }
}
