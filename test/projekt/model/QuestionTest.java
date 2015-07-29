package projekt.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by haerick on 29.07.15.
 */
public class QuestionTest {


    @Test
    public void testGetAnswers() {
        List<String> expected = new ArrayList<>();
        expected.add("Blau");
        expected.add("Gelb");
        expected.add("Neongrün");
        expected.add("Braun");

        Question question = new Question("Welche Farbe hat Cola?", expected, 3);

        assertEquals(expected, question.getAnswers());
    }

    @Test
    public void testToString() throws Exception {
        List<String> answers = new ArrayList<>();
        answers.add("Blau");
        answers.add("Gelb");
        answers.add("Neongrün");
        answers.add("Braun");

        String result = new Question("Welche Farbe hat Cola?", answers, 3).toString();
        assertEquals("Welche Farbe hat Cola? Blau; Gelb; Neongrün; Braun (✓)", result);
    }

    @Test
    public void testAddAnswer() throws Exception {
        Question question = new Question("Welche Farbe hat Cola?");
        assertEquals(new ArrayList<String>(), question.getAnswers());
        question.addAnswer("Blau");
        assertEquals("Blau", question.getAnswers().get(0));
    }


    @Test
    public void testAddCorrectAnswer() throws Exception {

    }

    @Test
    public void testIsValid() throws Exception {
        Question question = new Question("Welche Farbe hat Cola?");
        assertFalse(question.isValid());

        question.addCorrectAnswer("Braun");
        assertFalse(question.isValid());

        question.addAnswer("Blau");
        assertTrue(question.isValid());
    }

}
