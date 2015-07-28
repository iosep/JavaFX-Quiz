package projekt.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Klasse zum Einlesen der Fragen aus einer Datei
 * <p>
 * Die Zeilen in der Fragedatei müssen folgende Kennzeichnungen haben:
 * ###[Kategorie] ##[FRAGE]
 * ++[RICHTIGE ANTWORT]
 * --[FALSCHE ANTWORT]
 */
public class QuestionFileReader {

    /**
     * Returns a list filled with question objects parsed from a question file.
     *
     * @param path Path to question files.
     * @return List containing question objects.
     */
    public List<Question> getQuestionList(String path) {

        String content = readFile(path);


        if (content != null) {

            String[] categories = content.split("###");


        }
        return null;
    }


    /**
     * Reads a file and returns the content.
     *
     * @param path Path to file.
     * @return String with content.
     */
    public String readFile(String path) {
        StringBuilder sb = new StringBuilder();

        try {
            File questionFile = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(questionFile));

            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
