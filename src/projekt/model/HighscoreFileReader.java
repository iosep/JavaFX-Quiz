package projekt.model;

import projekt.MainApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasse zum Einlesen des Highscores aus einer Datei.
 */
public class HighscoreFileReader {

    private static List<String> playerImages;

    public static List<Player> parseScores(String path) throws IOException {
        playerImages = projekt.model.FileReader.getFileList("src/" + MainApplication.PATH_PLAYER_IMAGES);

        List<Player> highscore = new ArrayList<>(10);


        File highscoreFile = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(highscoreFile));

        String line = br.readLine();
        Player player;
        int i = 10;

        while (i-- > 0 && (line = br.readLine()) != null) {
            String[] lineData = line.split("|");
            highscore.add(new Player(Integer.parseInt(lineData[0]), lineData[1], Integer.parseInt(lineData[3])));
        }

        return highscore;
    }
}
