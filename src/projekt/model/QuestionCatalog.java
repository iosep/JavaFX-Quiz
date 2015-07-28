package projekt.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class which contains all questions. The questions ordered by categories in a map.
 */
public class QuestionCatalog {

    private Map<String, List<Question>> catalog;

    public QuestionCatalog() {
        catalog = new HashMap<>();
    }

    /**
     * Adds a single question to a category.
     *
     * @param category Category of the question.
     * @param question Question object.
     */
    public void addQuestion(String category, Question question) {
        if (catalog.containsKey(category)) {
            catalog.get(category).add(question);
        } else {
            List<Question> questions = new ArrayList<>();
            questions.add(question);
            catalog.put(category, questions);
        }
    }

    /**
     * Adds a List of questions to a category.
     *
     * @param category  Category of the questions.
     * @param questions List of Question object.
     */
    public void addQuestions(String category, List<Question> questions) {
        if (catalog.containsKey(category)) {
            catalog.get(category).addAll(questions);
        } else {
            catalog.put(category, questions);
        }
    }

    /**
     * Return all categories in catalog.
     *
     * @return Categories as string array.
     */
    public String[] getCategories() {
        return (String[]) catalog.keySet().toArray();
    }
}
