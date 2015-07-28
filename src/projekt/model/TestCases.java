package projekt.model;

import org.junit.Before;
import org.junit.Test;

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
        Question q = new Question("Welche Farbe hat Cola?", new String[]{"Blau", "Gelb", "Neongrün", "Braun"}, 3);

        assertEquals("Welche Farbe hat Cola? Blau; Gelb; Neongrün; Braun (✓)", q.toString());

    }

    @Test
    public void getQuestionList() {
        List<Question> result = qr.getQuestionList("src/projekt/data/test-questions.txt");

        for (Question question : result) {
            System.out.println(question);
        }
    }

    @Test
    public void testReadFile() throws Exception {
        String expected = "###Kultur" +
                "##Welche Farben hat die deutsche Flagge?" +
                "++Schwarz Rot Gold" +
                "--Rot Weiß gestreift" +
                "--Bunt" +
                "--Pink" +
                "##Was gehört traditionell zu einem bayrischen Frühstück dazu?" +
                "++Weißwurst" +
                "--Fish & Chips" +
                "--Spiegelei" +
                "--Bohnen";

        String result = qr.readFile("src/projekt/data/test-questions.txt");
        assertEquals(expected, result);
    }
}
