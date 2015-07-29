package projekt.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Test class
 */
public class TestCases {

    QuestionFileReader qr;

    @Before
    public void setUp() throws Exception {
        qr = new QuestionFileReader();
    }

    @Test
    public void questionToString() {
        List<String> answers = new ArrayList<>();
        answers.add("Blau");
        answers.add("Gelb");
        answers.add("Neongrün");
        answers.add("Braun");

        String result = new Question("Welche Farbe hat Cola?", answers, 3).toString();
        assertEquals("Welche Farbe hat Cola? Blau; Gelb; Neongrün; Braun (✓)", result);
    }

    @Test
    public void getQuestionList() {
        QuestionCatalog expected = new QuestionCatalog();
        Question q = new Question("Welche Farben hat die deutsche Flagge?");
        q.addCorrectAnswer("Schwarz Rot Gold");
        q.addAnswer("Rot Weiß");
        q.addAnswer("Bunt");
        q.addAnswer("Pink");
        expected.addQuestion("Kultur", q);

        q = new Question("Was gehört traditionell zu einem bayrischen Frühstück dazu?");
        q.addCorrectAnswer("Weißwurst");
        q.addAnswer("Fish & Chips");
        q.addAnswer("Spiegelei");
        q.addAnswer("Bohnen");
        expected.addQuestion("Kultur", q);

        q = new Question("Bei welcher Sportart muss man möglichst weit springen?");
        q.addCorrectAnswer("Hochsprung");
        q.addAnswer("Weitsprung");
        q.addAnswer("Stabhochsprung");
        q.addAnswer("Schach");
        expected.addQuestion("Sport", q);

        QuestionCatalog result = qr.parseQuestions("src/projekt/data/test-questions.txt");

        assertEquals(expected.getQuestion("Sport", 0).toString(), result.getQuestion("Sport", 0).toString());
        assertEquals(expected.getQuestion("Kultur", 0).toString(), result.getQuestion("Kultur", 0).toString());
        assertEquals(expected.getQuestion("Kultur", 1).toString(), result.getQuestion("Kultur", 1).toString());
    }


}
