package projekt.model;

import projekt.MainApplication;

import java.util.*;

/**
 * Klasse die zur Erstellung eines Katalogs mit Fragen dient.
 * Sie enthält Methoden zur Verwaltung von Fragen und Kategorien.
 * Die Fragen werden in Kategorien angeordnet.
 */
public class QuestionCatalog {

    public Map<String, List<Question>> catalog;

    /**
     * Konstruktor für einen leeren Fragenkatalog.
     */
    public QuestionCatalog() {
        catalog = new HashMap<>();
    }

    /**
     * Fügt eine Frage zu einer Kategorie hinzu
     *
     * @param category Kategorie der Frage.
     * @param question Entsprechendes Questionobjekt.
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
     * Fügt eine Liste von Fragen zu einer Kategorie hinzu
     *
     * @param category  Kategorie der Fragen.
     * @param questions Entsprechende Liste mit Questionobjekten.
     */
    public void addQuestions(String category, List<Question> questions) {
        if (catalog.containsKey(category)) {
            catalog.get(category).addAll(questions);
        } else {
            catalog.put(category, questions);
        }
    }

    /**
     * Gibt eine zufällige Frage zu einer Kategorie zurück.
     *
     * @param category Kategorie, aus der die Frage ausgewählt werden soll.
     * @return Zufällige Frage aus der angegebenen Kategorie.
     */
    public Question getRandomQuestion(String category) {
        Random random = new Random();
        List<Question> categoryCatalog = catalog.get(category);
        return categoryCatalog.get(random.nextInt(categoryCatalog.size()));
    }

    /**
     * Gibt eine bestimmte Frage, die am angegebenen Index aus einer Kategorie liegt, zurück.
     *
     * @param category Kategorie, aus der die Frage ausgewählt wird.
     * @param index    Index der Frage, die ausgewählt wird.
     * @return Ausgewähltes Questionobjekt.
     */
    public Question getQuestion(String category, int index) {
        return catalog.get(category).get(index);
    }

    /**
     * Gibt alle Kategorien des Katalogs zurück, die eine entsprechende Anzahl an Fragen besitzen.
     *
     * @param numQuestions Mindestanzahl an Fragen, die eine Kategorie haben muss.
     * @return Kategorien als String List.
     */
    public List<String> getCategories(int numQuestions) {
        List<String> result = new ArrayList<>(catalog.size());

        for (String s : catalog.keySet()) {
            if (catalog.get(s).size() >= numQuestions) {
                result.add(s);
            }
        }

        result.sort(Comparator.<String>naturalOrder());
        return result;
    }

    /**
     * Gibt die Anzahl der Kategorien zurück.
     *
     * @return Anzahl der Kategorien.
     */
    public int getNumCategories() {
        return catalog.size();
    }

}
