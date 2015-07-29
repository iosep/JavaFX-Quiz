package projekt.model;

import java.util.*;

/**
 * Class which contains all questions. The questions ordered by categories in a map.
 */
public class QuestionCatalog {

    public Map<String, List<Question>> catalog;

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

    public Question getRandomQuestion(String category) {
        Random random = new Random();
        List<Question> categoryCatalog = catalog.get(category);
        return categoryCatalog.get(random.nextInt(categoryCatalog.size()));
    }

    public Question getQuestion(String category, int index) {
        return catalog.get(category).get(index);
    }

    /**
     * Return all categories in catalog.
     *
     * @return Categories as string array.
     */
    public String[] getCategories() {
        String[] result = new String[catalog.size()];
        catalog.keySet().toArray(result);
        Arrays.sort(result);

        return result;
    }
}
