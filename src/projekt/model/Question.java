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

    public Question(String question) {
        QUESTION = question;
        ANSWERS = new ArrayList<>(4);
        correctAnswerIndex = -1;
    }

    public Question(String question, List<String> answers, int correctAnswerIndex) {
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

    public boolean isValid() {
        return !QUESTION.isEmpty() && ANSWERS.size() >= 2 && correctAnswerIndex > -1 && correctAnswerIndex < ANSWERS.size();
    }

    public void addAnswer(String answer) {
        ANSWERS.add(answer);
    }

    public void addCorrectAnswer(String answer) {
        ANSWERS.add(answer);
        correctAnswerIndex = ANSWERS.size() - 1;
    }

    public List<String> getAnswers() {
        return ANSWERS;
    }
}
