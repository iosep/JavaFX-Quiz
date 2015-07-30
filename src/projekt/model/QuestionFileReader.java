package projekt.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Klasse zum Einlesen der Fragen aus einer Datei
 */
public class QuestionFileReader {

    private static final String CATEGORY_SEPARATOR = "---";
    private static final String QUESTION_SEPARATOR = "#";
    private static final String CORRECT_ANSWER_INDICATOR = "+";

    /**
     * Parses a question file and returns a questionCatalog
     *
     * @param path Path to question file.
     * @return QuestionCatalog with question objects.
     */
    public static QuestionCatalog parseQuestions(String path) throws IOException {
        QuestionCatalog catalog = new QuestionCatalog();

        File questionFile = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(questionFile));

        String line = br.readLine();
        String category = null;
        Question question;

        do {
            if (line.startsWith(CATEGORY_SEPARATOR)) {
                category = line.substring(CATEGORY_SEPARATOR.length());
                line = br.readLine();
            } else if (line.startsWith(QUESTION_SEPARATOR)) {
                question = new Question(line.substring(QUESTION_SEPARATOR.length()));

                while ((line = br.readLine()) != null &&
                        !line.startsWith(CATEGORY_SEPARATOR) &&
                        !line.startsWith(QUESTION_SEPARATOR)) {

                    if (line.startsWith(CORRECT_ANSWER_INDICATOR)) {
                        question.addCorrectAnswer(line.substring(1));
                    } else {
                        question.addAnswer(line);
                    }
                }

                if (question.isValid()) {
                    catalog.addQuestion(category, question);
                } else {
                    throw new IllegalStateException("Question is not valid. Check question file. " + question);
                }
            }
        } while (line != null);

        return catalog;
    }
}
