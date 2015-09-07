package projekt.io;

import projekt.MainApplication;
import projekt.controller.ScreenController;
import projekt.model.Question;
import projekt.model.QuestionCatalog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Klasse zum Einlesen der Fragen aus einer Datei.
 */
public class QuestionFileIO {

    private static final String CATEGORY_SEPARATOR = "---";
    private static final String QUESTION_SEPARATOR = "#";
    private static final String CORRECT_ANSWER_INDICATOR = "+";

    /**
     * Liest alle Fragen aus der fragen-Datei und gibt dementsprechend einen QuestionCatalog zurück.
     *
     * @return QuestionCatalog mit Question-Objeken.
     * @throws IOException wenn die fragen-Datei nicht geladen werden kann.
     */
    public static QuestionCatalog parseQuestions() throws IOException {
        QuestionCatalog catalog = new QuestionCatalog();

        File questionFile = new File(MainApplication.PATH_QUESTIONS);
        BufferedReader br = new BufferedReader(new FileReader(questionFile));

        String line = br.readLine();
        String category = null;
        Question question;
        int questionNum = 0;

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
                        question.addCorrectAnswer(line.substring(CORRECT_ANSWER_INDICATOR.length()));
                    } else {
                        question.addAnswer(line);
                    }
                }

                if (question.isValid()) {
                    catalog.addQuestion(category, question);
                    questionNum++;
                } else {
                    ScreenController.showWarningNotification("Question is not valid. Check question:\n" + question);
                }
            }
        } while (line != null);

        int categoryNum = catalog.getNumCategories();
        List<String> categories = catalog.getCategories();
        ScreenController.showInformationNotification("Got " + questionNum + " questions in " + categoryNum + " categories.");

        if (categories.size() < categoryNum) {
            ScreenController.showInformationNotification("But can only use " + categories.size() + " categories:");
            for (String c : categories) {
                ScreenController.showInformationNotification(c);
            }
        }

        return catalog;
    }
}
