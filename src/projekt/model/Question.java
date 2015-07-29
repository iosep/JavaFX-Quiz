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
    private int CORRECT_ANSWER_IDX;

    public Question(String question) {
        QUESTION = question;
        ANSWERS = new ArrayList<>(4);
        CORRECT_ANSWER_IDX = -1;
    }

    public Question(String question, List<String> answers, int correctAnswerIdx) {
        QUESTION = question;
        ANSWERS = answers;
        CORRECT_ANSWER_IDX = correctAnswerIdx;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(QUESTION);
        sb.append(" ");

        for (int i = 0; i < ANSWERS.size(); i++) {
            sb.append(ANSWERS.get(i));

            if (i == CORRECT_ANSWER_IDX) {
                sb.append(" (").append("\u2713").append(")");
            }

            if (i < ANSWERS.size() - 1) {
                sb.append("; ");
            }
        }

        return sb.toString();
    }

    public boolean isValid() {
        return !QUESTION.isEmpty() && !ANSWERS.isEmpty() && CORRECT_ANSWER_IDX > -1;
    }

    public void addAnswer(String answer) {
        ANSWERS.add(answer);
    }

    public void addCorrectAnswer(String answer) {
        ANSWERS.add(answer);
        CORRECT_ANSWER_IDX = ANSWERS.size() - 1;
    }
}
