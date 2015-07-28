package projekt.model;

/**
 * Klasse zum Erstellen von Question-Objekten.
 * Sie enthält die Frage, die Antwortmöglichkeiten als Array und die richtige Antwort als Index in dem Array.
 */
public class Question {

    public final String QUESTION;
    public final String[] ANSWERS;
    public final int CORRECT_ANSWER_IDX;

    public Question(String question, String[] answers, int correctAnswerIdx) {
        QUESTION = question;
        ANSWERS = answers;
        CORRECT_ANSWER_IDX = correctAnswerIdx;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(QUESTION);
        sb.append(" ");

        // Welche Farbe hat Cola? Blau; Gelb; Neongrün; Braun (✓)
        for (int i = 0; i < ANSWERS.length; i++) {
            sb.append(ANSWERS[i]);

            if (i == CORRECT_ANSWER_IDX) {
                sb.append(" (").append("\u2713").append(")");
            }

            if (i < ANSWERS.length - 1) {
                sb.append("; ");
            }
        }

        return sb.toString();
    }
}
